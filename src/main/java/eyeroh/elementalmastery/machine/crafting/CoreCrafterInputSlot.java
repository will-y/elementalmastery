package eyeroh.elementalmastery.machine.crafting;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CoreCrafterInputSlot extends SlotItemHandler {

	
	private boolean isCenter;
	
	public CoreCrafterInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, boolean isCenter) {
		super(itemHandler, index, xPosition, yPosition);
		this.isCenter = isCenter;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
        if(isCenter) {
        	return CoreCrafterUtilities.isItemValidInside(stack);
        } else {
        	return CoreCrafterUtilities.isItemValidOutside(stack);
        }
    }
}
