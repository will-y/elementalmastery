package eyeroh.elementalmastery.machine.collector;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CollectorSlot extends SlotItemHandler{
	public CollectorSlot(IItemHandler iItemHandler, int slotIndex, int xPosition, int yPosition)
    {
        super(iItemHandler, slotIndex, xPosition, yPosition);
    }
	
	public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
}
