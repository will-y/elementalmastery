package eyeroh.elementalmastery.machine.collector;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class CollectorHealContainer extends CollectorContainer {

	public CollectorHealContainer(InventoryPlayer playerInventory, IInventory iInventory, TileCollector te) {
		super(playerInventory, iInventory, te);
	}
	
	@Override
	public void addOwnSlots() {
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int x = 26;
		int y = 39;
		int slotIndex = 0;
		
		for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 36;
        }
		addSlotToContainer(new CollectorSlot(itemHandler, 4, 80, 63));
	}

}
