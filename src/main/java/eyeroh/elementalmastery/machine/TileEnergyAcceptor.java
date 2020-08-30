package eyeroh.elementalmastery.machine;

import java.util.ArrayList;

import com.google.common.primitives.Ints;

import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;

public abstract class TileEnergyAcceptor extends TileEntity implements ITickable {
	
	public int[] currentEnergy = new int[] {0, 0, 0, 0};
	public int[] storage;
	public int[] usage;
	public int energyCoolDown = 20;
	public int energyCounter = 0;
	public int energyUseCounter = 0;
	protected TileEntityCapacitorController linkedCapacitor = null;
	private BlockPos capacitorPos;
	private int maxProgress;
	private int currentProgress = 0;
	
	public boolean active = false;
	
	public TileEnergyAcceptor(int[] storage, int[] usage, int maxProgress) {
		super(TileEntityType.CHEST);
		this.storage = storage;
		this.usage = usage;
		this.maxProgress = maxProgress;
	}
	
	@Override
    public CompoundNBT getUpdateTag() {
        return write(new CompoundNBT());
    }

//    @Override
//    public SPacketUpdateTileEntity getUpdatePacket() {
//        NBTTagCompound nbtTag = new NBTTagCompound();
//        this.writeToNBT(nbtTag);
//        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
//    }
//
//    @Override
//    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
//        this.readFromNBT(packet.getNbtCompound());
//    }
//
//	@Override
//    public void readFromNBT(NBTTagCompound compound) {
//        super.readFromNBT(compound);
//    	this.currentEnergy = compound.getIntArray("energy");
//    	this.usage = compound.getIntArray("usage");
//    	this.currentProgress = compound.getInteger("progress");
//    	this.maxProgress = compound.getInteger("max_progress");
//    	this.storage = compound.getIntArray("storage");
//    	this.energyCounter = compound.getInteger("energy_counter");
//    	this.energyUseCounter = compound.getInteger("energy_use_counter");
//        if(compound.hasKey("capacitor")) {
//        	this.capacitorPos = BlockPos.fromLong(compound.getLong("capacitor"));
//        }
//    }
	
    @Override
    public CompoundNBT write(CompoundNBT compound) {
    	compound.putIntArray("energy", currentEnergy);
    	compound.putIntArray("usage", this.usage);
    	compound.putInt("progress", this.currentProgress);
    	compound.putInt("max_progress", this.maxProgress);
    	compound.putIntArray("storage", this.storage);
    	compound.putInt("energy_counter", this.energyCounter);
    	compound.putInt("energy_use_counter", this.energyUseCounter);
    	if(linkedCapacitor != null) {
    		compound.putLong("capacitor", this.linkedCapacitor.getPos().toLong());
    	}
        return super.write(compound);
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
		if(currentEnergy[type] - amount >= 0 ) {
			currentEnergy[type] -= amount;
			this.markDirty();
		}
	}
	
	public void useAllEnergy() {
		if(energyUseCounter >= energyCoolDown) {
			energyUseCounter = 0;
			for(int i = 0; i < 4; i++) {
				this.useEnergy(i, usage[i]);
			}
		}
		energyUseCounter++;
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
	
	/*
	 * Action that the machine does with it has enough energy to run
	 */
	public abstract void doAction();
	
	public boolean getActive() {
		try {
			for(int i = 0; i < 4; i++) {
				if(this.getUsage()[i] != 0) {
					if(this.getUsage()[i] > this.getCurrentEnergy(i)) {
						return false;
					}
				}
			}
			return true;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Error in the tile entity, break and replace to fix");
			return false;
		}
		
	}

    public int getCurrentProgress() {
    	return this.currentProgress;
    }
	
	public void setCurrentProgress(int data) {
		this.currentProgress = data;
	}
	
	public int getMaxProgress() {
		return this.maxProgress;
	}

	@Override
	public void tick() {
		retrieveEnergy();
		if(this.getActive()) {
			this.useAllEnergy();
			if(!world.isRemote) {
				if(currentProgress >= maxProgress) {
					doAction();
					currentProgress = 0;
					markDirty();
				}
				currentProgress++;
			}
		}
	}
	
	public void retrieveEnergy() {
		try {
			if(this.linkedCapacitor == null && capacitorPos != null) {
				TileEntity te = world.getTileEntity(this.capacitorPos);
				if(te instanceof TileEntityCapacitorController) {
					this.linkedCapacitor = (TileEntityCapacitorController) te;
				}
			}
			if(this.linkedCapacitor != null) {
				if(energyCounter >= energyCoolDown) {
					energyCounter = 0;
					
					for(int i = 0; i < 4; i++) {
						if(this.canAcceptEnergy(this.usage[i] * 2, i)) {
							//int amount = this.linkedCapacitor.takeEnergy(this.usage[i] * 2, i);
							//this.currentEnergy[i] += amount;
						}
					}
					
					
				}
				energyCounter++;
			}
			this.markDirty();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error getting energy, break and replace the machine to fix");
		}
	}
    
    public boolean canInteractWith(PlayerEntity playerIn) {
		return false;
        //return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }
    
    public String getName() {
		return "";
	}

	public boolean hasCustomName() {
		return false;
	}
	
//	@Override
//	public ITextComponent getDisplayName() {
//		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
//	}
	
	public void addCapacitor(TileEntityCapacitorController te) {
		this.linkedCapacitor = te;
	}
	
	public int getCurrentEnergy(int type) {
		return this.currentEnergy[type];
	}
	
	public boolean canAcceptEnergy(int amount, int type) {
		return this.currentEnergy[type] + amount <= this.getMaxEnergy(type);
	}
	
	public ArrayList<String> getToolTipString(int type) {
    	String result = this.currentEnergy[type] + "/" + this.getMaxEnergy(type);
		ArrayList<String> list = new ArrayList<String>();
		list.add(result);
		return list;
    }
	
	public void setMaxProgress(int max) {
		this.maxProgress = max;
	}
}
