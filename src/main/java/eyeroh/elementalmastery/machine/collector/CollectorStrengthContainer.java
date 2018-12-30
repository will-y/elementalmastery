package eyeroh.elementalmastery.machine.collector;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class CollectorStrengthContainer extends CollectorContainer {

	public CollectorStrengthContainer(InventoryPlayer playerInventory, IInventory iInventory, TileCollector te) {
		super(playerInventory, iInventory, te);
	}
	
	@Override
	public void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 26;
        int y = 31;

        int slotIndex = 0;
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < itemHandler.getSlots()/2; j++) {
        		addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
                slotIndex++;
                x += 36;
        	}
        	y += 26;
        	x = 26;
        }
    }

}
