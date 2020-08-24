package eyeroh.elementalmastery.machine;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public abstract class GemContainer extends Container {
	public TileEnergyAcceptorInventory te;
    private int lastProgress = 0;
    private int playerX;
    private int playerY;
    
	public GemContainer(PlayerInventory playerInventory, IInventory iInventory, TileEnergyAcceptorInventory te, int playerX, int playerY) {
        super(ContainerType.CRAFTING, -1);
        this.te = te;
		this.playerX = playerX;
		this.playerY = playerY;
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}
	
	public abstract void addOwnSlots();
	
	private void addPlayerSlots(PlayerInventory playerInventory) {
        // Slots for the main inventory
//        for (int row = 0; row < 3; ++row) {
//            for (int col = 0; col < 9; ++col) {
//                int x = playerX + col * 18;
//                int y = playerY + row * 18;
//                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x, y));
//            }
//        }

        // Slots for the hotbar
//        for (int row = 0; row < 9; ++row) {
//            int x = playerX + row * 18;
//            //int y = 142;
//            int y = playerY + 58;
//            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
//        }
    }
	
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
