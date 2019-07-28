package eyeroh.elementalmastery.machine;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public abstract class TileEnergyAcceptor extends TileEntity implements ITickable{
	
	public int[] currentEnergy = new int[] {0, 0, 0, 0};
	public int[] storage;
	public int[] usage;
	public int counter = 0;
	public int energyCoolDown = 20;
	public int energyCounter = 0;
	public int energyUseCounter = 0;
	protected TileEntityCapacitorController linkedCapacitor = null;
	private BlockPos capacitorPos;
	
	public boolean active = false;
	
	public TileEnergyAcceptor(int[] storage, int[] usage, int size) {
		this.storage = storage;
		this.usage = usage;
		
	}
	
	@Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    	this.currentEnergy = compound.getIntArray("energy");
    	this.counter = compound.getInteger("counter");
    	this.usage = compound.getIntArray("usage");
    	this.storage = compound.getIntArray("storage");
    	this.energyCounter = compound.getInteger("energy_counter");
    	this.energyUseCounter = compound.getInteger("energy_use_counter");
        if(compound.hasKey("capacitor")) {
        	this.capacitorPos = BlockPos.fromLong(compound.getLong("capacitor"));
        }
        
        
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    	compound.setIntArray("energy", currentEnergy);
    	compound.setInteger("counter", this.counter);
    	compound.setIntArray("usage", this.usage);
    	compound.setIntArray("storage", this.storage);
    	compound.setInteger("energy_counter", this.energyCounter);
    	compound.setInteger("energy_use_counter", this.energyUseCounter);
    	if(linkedCapacitor != null) {
    		compound.setLong("capacitor", this.linkedCapacitor.getPos().toLong());
    	}
        return super.writeToNBT(compound);
    }
	
	public boolean addEnergy(int type, int amount) {
		if(currentEnergy[type] + amount <= storage[type]) {
			currentEnergy[type]+=amount;
			this.markDirty();
			return true;
		}
		return false;
	}
	
	public void useEnergy(int type, int amount) {
		if(energyUseCounter >= energyCoolDown) {
			energyUseCounter = 0;
			if(currentEnergy[type] - amount >= 0 ) {
				currentEnergy[type]-=amount;
				this.markDirty();
			}
		}
		energyUseCounter++;
	}
	
	public void useAllEnergy() {
		for(int i = 0; i < 4; i++) {
			this.useEnergy(i, usage[i]);
		}
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public int[] getUsage() {
		return usage;
	}
	
	public int getUsage(int type) {
		if(type > 3) {
			return -1;
		}
		return usage[type];
	}
	
	public int getEnergy(int type) {
		return currentEnergy[type];
	}
	
	public int getMaxEnergy(int type) {
		return storage[type];
	}
	
	public int getMaxEnergy() {
		return Ints.max(storage);
	}
	
	public void actionPerTick() {
		
	}
	
	public void setCurrentProgress(int data) {
		counter = data;
	}
	
	public int getCurrentProgress() {
		return counter;
	}

	@Override
	public void update() {
		actionPerTick();
		
	}
	
	public void retrieveEnergy() {
		if(this.linkedCapacitor == null && capacitorPos != null) {
			TileEntity te = world.getTileEntity(this.capacitorPos);
			if(te instanceof TileEntityCapacitorController) {
				this.linkedCapacitor = (TileEntityCapacitorController) te;
			}
		}
		if(this.linkedCapacitor != null && this.canAcceptEnergy(this.usage[this.getType()] * 2, this.getType())) {
			if(energyCounter >= energyCoolDown) {
				energyCounter = 0;
				
				for(int i = 0; i < 4; i++) {
					int amount = this.linkedCapacitor.takeEnergy(this.usage[i] * 2, i);
					this.currentEnergy[i] += amount;
				}
				
				
			}
			energyCounter++;
		}
		this.markDirty();
	}
    
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }
    
    public String getName() {
		return "";
	}

	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	public void addCapacitor(TileEntityCapacitorController te) {
		this.linkedCapacitor = te;
	}
	
	public int getCurrentEnergy(int type) {
		return this.currentEnergy[type];
	}
	
	public boolean canAcceptEnergy(int amount, int type) {
		return this.currentEnergy[type] + amount <= this.getMaxEnergy(type);
	}
	
	public abstract int getType();
}
