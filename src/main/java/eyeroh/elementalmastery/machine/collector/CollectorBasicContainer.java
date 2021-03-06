package eyeroh.elementalmastery.machine.collector;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class CollectorBasicContainer extends Container {
	public CollectorBasicTileEntity te;
	private int lastProgress = 0;
	
	public CollectorBasicContainer(PlayerInventory playerInventory, IInventory iInventory, CollectorBasicTileEntity te) {
        super(ContainerType.CRAFTING, -1);
        this.te = te;
//		this.addPlayerSlots(playerInventory);
//		this.addOwnSlots();
	}
	
//	private void addPlayerSlots(PlayerInventory playerInventory) {
//        // Slots for the main inventory
//        for (int row = 0; row < 3; ++row) {
//            for (int col = 0; col < 9; ++col) {
//                int x = 8 + col * 18;
//                int y = row * 18 + 84;
//                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x, y));
//            }
//        }
//
//        // Slots for the hotbar
//        for (int row = 0; row < 9; ++row) {
//            int x = 8 + row * 18;
//            int y = 142;
//            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
//        }
//    }
//
//	public void addOwnSlots() {
//        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
//        int x = 26;
//        int y = 39;
//
//        int slotIndex = 0;
//        for (int i = 0; i < itemHandler.getSlots(); i++) {
//            addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
//            slotIndex++;
//            x += 36;
//        }
//    }
	
	@Nullable
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < CollectorBasicTileEntity.SIZE) {
                if (!this.mergeItemStack(itemstack1, CollectorBasicTileEntity.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
	
	@Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return te.canInteractWith(playerIn);
    }
    
//    @Override
//    public void detectAndSendChanges() {
//    	super.detectAndSendChanges();
//
//    	for(IContainerListener crafting : listeners) {
//    		if(lastProgress == te.getCurrentProgress()) continue;
//    		crafting.sendWindowProperty(this, 0, te.getCurrentProgress());
//    	}
//
//    	lastProgress = te.getCurrentProgress();
//    }
    
    @Override
    public void updateProgressBar(int id, int data) {
    	if(id == 0) {
    		te.setCurrentProgress(data);
    	}
    }
}
