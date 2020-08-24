package eyeroh.elementalmastery.machine;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileEnergyAcceptorInventory extends TileEnergyAcceptor {
		
	private int size;
	private ItemStackHandler itemStackHandler;
	
	public TileEnergyAcceptorInventory(int[] storage, int[] usage, int size, int maxProgress) {
		super(storage, usage, maxProgress);
		this.size = size;
		itemStackHandler = new ItemStackHandler(size) {
	        @Override
	        protected void onContentsChanged(int slot) {
	            TileEnergyAcceptorInventory.this.markDirty();
	        }
	        
	        @Override
	        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
	            return TileEnergyAcceptorInventory.this.isItemValid(slot, stack);
	        }
		};
	}

	@Override
	public abstract void doAction();
	
	public abstract boolean isItemValid(int slot, ItemStack stack);
	
//	@Override
//    public boolean hasCapability(Capability<?> capability, Direction facing) {
//        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//            return true;
//        }
//        return super.hasCapability(capability, facing);
//    }

//    @Override
//    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
//        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
//        }
//        return super.getCapability(capability, facing);
//    }
    
//    @Override
//    public void readFromNBT(NBTTagCompound compound) {
//        super.readFromNBT(compound);
//        if (compound.hasKey("items")) {
//            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
//        }
//    }
	
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        //compound.setTag("items", itemStackHandler.serializeNBT());
        return super.write(compound);
    }
    
    public void addItem(ItemStack item, int slot) {
		getItemStackHandler().insertItem(slot, item, false);
	}
    
    public ItemStackHandler getItemStackHandler() {
		return itemStackHandler;
	}
}
