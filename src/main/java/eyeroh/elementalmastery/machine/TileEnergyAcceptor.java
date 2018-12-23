package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEnergyAcceptor extends TileEntity implements ITickable{
	
	public int[] currentEnergy = new int[] {0, 0, 0, 0};
	public int[] storage = new int[] {0, 0, 0, 0};
	public int[] usage = new int[] {0, 0, 0, 0};
	public int counter = 0;
	
	public boolean active = false;
	
	public int SIZE = 0;
	
	public TileEnergyAcceptor(int[] storage, int[] usage, int size) {
		this.storage = storage;
		this.usage = usage;
		this.SIZE = size;
	}
	
	public void addEnergy(int type, int amount) {
		if(currentEnergy[type] + amount <= storage[type]) {
			currentEnergy[type]+=amount;
		}
	}
	
	public void useEnergy(int type, int amount) {
		currentEnergy[type]-=amount;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public int getEnergy(int type) {
		return currentEnergy[type];
	}
	
	public int getMaxEnergy(int type) {
		return storage[type];
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
		if(active) {
			for(int i = 0; i < 4; i++) {
				if(currentEnergy[i] - usage[i] <= 0) {
					setActive(false);
				} else {
					currentEnergy[i] -= usage[i];
					actionPerTick();
				}
			}
		}
	}
	
	private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            TileEnergyAcceptor.this.markDirty();
        }
    };
    
    public ItemStackHandler getItemStackHandler() {
    	return itemStackHandler;
    }
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("items", itemStackHandler.serializeNBT());
        return super.writeToNBT(compound);
    }
    
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
        }
        return super.getCapability(capability, facing);
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
}
