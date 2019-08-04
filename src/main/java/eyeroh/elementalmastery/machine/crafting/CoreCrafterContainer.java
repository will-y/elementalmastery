package eyeroh.elementalmastery.machine.crafting;

import eyeroh.elementalmastery.machine.GemContainer;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import eyeroh.elementalmastery.machine.collector.CollectorSlot;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CoreCrafterContainer extends GemContainer {

	public CoreCrafterContainer(InventoryPlayer playerInventory, IInventory iInventory, TileEnergyAcceptorInventory te) {
		super(playerInventory, iInventory, te, 8, 100);
	}

	@Override
	public void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        
        addSlotToContainer(new CoreCrafterInputSlot(itemHandler, 0, 30, 38, false));
        addSlotToContainer(new CoreCrafterInputSlot(itemHandler, 1, 56, 12, false));
        addSlotToContainer(new CoreCrafterInputSlot(itemHandler, 2, 82, 38, false));
        addSlotToContainer(new CoreCrafterInputSlot(itemHandler, 3, 56, 64, false));
        addSlotToContainer(new CoreCrafterInputSlot(itemHandler, 4, 56, 38, true));
        addSlotToContainer(new SlotItemHandler(itemHandler, 5, 105, 38) {
        	@Override
        	public boolean isItemValid(ItemStack stack) {
        		return false;
        	}
        });
    }

}
