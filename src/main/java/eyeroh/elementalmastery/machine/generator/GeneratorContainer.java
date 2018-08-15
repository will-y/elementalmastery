package eyeroh.elementalmastery.machine.generator;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.collector.CollectorSlot;
import eyeroh.elementalmastery.machine.collector.CollectorTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GeneratorContainer extends Container{
	public GeneratorTileEntity te;
	
	public GeneratorContainer(InventoryPlayer playerInventory, IInventory iInventory, GeneratorTileEntity te) {
        this.te = te;

        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(InventoryPlayer playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 8 + col * 18;
                int y = row * 18 + 84;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x, y));
            }
        }
        for (int row = 0; row < 9; ++row) {
            int x = 8 + row * 18;
            int y = 142;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 27;
        int y = 35;
        
        switch(te.getType()) {
        case 0:
        	addSlotToContainer(new GeneratorSlot(itemHandler, 0, x, y, new Item[] {ModItems.gemOpal, Item.getItemFromBlock(ModBlocks.blockopal)}));
        	break;
        case 1:
        	addSlotToContainer(new GeneratorSlot(itemHandler, 0, x, y, new Item[] {ModItems.gemTopaz, Item.getItemFromBlock(ModBlocks.blocktopaz)}));
        	break;
        case 2:
        	addSlotToContainer(new GeneratorSlot(itemHandler, 0, x, y, new Item[] {ModItems.gemRuby, Item.getItemFromBlock(ModBlocks.blockruby)}));
        	break;
        case 3:
        	addSlotToContainer(new GeneratorSlot(itemHandler, 0, x, y, new Item[] {ModItems.gemSapphire, Item.getItemFromBlock(ModBlocks.blocksapphire)}));
        	break;
        }
        
    }
    
    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < CollectorTileEntity.SIZE) {
                if (!this.mergeItemStack(itemstack1, CollectorTileEntity.SIZE, this.inventorySlots.size(), true)) {
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
	public boolean canInteractWith(EntityPlayer playerIn) {
		return te.canInteractWith(playerIn);
	}
	
	private int progress;
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		int prog = te.getCurrentProgress();
		
		for(IContainerListener listener : listeners) {
			if(prog != progress) {
				listener.sendWindowProperty(this, 0, prog);
			}
		}
		
		this.progress = prog;
	}
}
