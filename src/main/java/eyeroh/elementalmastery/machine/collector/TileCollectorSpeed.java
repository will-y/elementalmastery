package eyeroh.elementalmastery.machine.collector;

import net.minecraft.item.ItemStack;

public class TileCollectorSpeed extends TileCollector {

	public TileCollectorSpeed() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 4, getDefaultItemStackArray(), 100);
	}
}
