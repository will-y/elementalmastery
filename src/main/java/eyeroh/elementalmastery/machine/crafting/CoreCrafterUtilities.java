package eyeroh.elementalmastery.machine.crafting;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CoreCrafterUtilities {
	private static ArrayList<ItemStack> validEdge = new ArrayList<ItemStack>();
	private static ArrayList<ItemStack> validCenter = new ArrayList<ItemStack>();
	
	public CoreCrafterUtilities () {
		
		
	}
	
	public static boolean isItemValidOutside(ItemStack stackIn) {
		return stackIn.isItemEqual(new ItemStack(Items.REDSTONE));
	}
	
	public static boolean isItemValidInside(ItemStack stackIn) {
		return stackIn.isItemEqual(new ItemStack(Items.STICK));
	}
}
