package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorHeal extends TileCollector {
	
	private ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.dustOpalSmall), new ItemStack(ModItems.dustTopazSmall), new ItemStack(ModItems.dustRubySmall), new ItemStack(ModItems.dustSapphireSmall), new ItemStack(ModItems.smallHeart)};
	
	
	public TileCollectorHeal() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 4, getDefaultItemStackArray(), 200);
	}
}
