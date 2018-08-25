package eyeroh.elementalmastery.machine.collector;

import net.minecraft.item.ItemStack;

public class TileCollectorStrength extends TileCollector {

	public TileCollectorStrength() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 8, getDefaultItemStackArray(), 100);
	}
}
