package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorFire extends TileCollector {
	private static ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.nuggetOpal), new ItemStack(ModItems.nuggetTopaz), new ItemStack(ModItems.nuggetRuby), new ItemStack(ModItems.nuggetSapphire)};
	public TileCollectorFire() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 4, itemsGenerated, 200);
	}
}
