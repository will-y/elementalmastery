package eyeroh.elementalmastery.machine.collector;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class CollectorHealContainer extends CollectorContainer {

	public CollectorHealContainer(PlayerInventory playerInventory, IInventory iInventory, TileCollector te) {
		super(playerInventory, iInventory, te);
	}
	
//	@Override
//	public void addOwnSlots() {
//		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
//		int x = 26;
//		int y = 39;
//		int slotIndex = 0;
//		System.out.println("Number of slots:" + itemHandler.getSlots());
//		for (int i = 0; i < itemHandler.getSlots() - 1; i++) {
//            addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
//            slotIndex++;
//            x += 36;
//        }
//		addSlotToContainer(new CollectorSlot(itemHandler, 4, 80, 63));
//	}

}
