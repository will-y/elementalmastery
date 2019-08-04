package eyeroh.elementalmastery.machine.crafting;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CoreCrafterUtilities {
	private static ArrayList<ItemStack> validEdge = new ArrayList<ItemStack>();
	private static ArrayList<ItemStack> validCenter = new ArrayList<ItemStack>();
	
	public CoreCrafterUtilities () {
		validEdge.add(new ItemStack(Items.REDSTONE));
		validCenter.add(new ItemStack(Items.STICK));
	}
	
	public static boolean isItemValidOutside(ItemStack stackIn) {
		for(ItemStack stack : validEdge) {
			if(stackIn.isItemEqual(stack)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isItemValidInside(ItemStack stackIn) {
		for(ItemStack stack : validCenter) {
			if(stackIn.isItemEqual(stack)) {
				return true;
			}
		}
		return false;
	}
}
