package eyeroh.elementalmastery.machine.collector;

import net.minecraft.item.ItemStack;

public class TileCollectorStrength extends TileCollector {

	public TileCollectorStrength() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 8, getDefaultItemStackArray(), 100);
	}
	
	@Override
	public String getName() {
		return "Strength Collector";
	}
	
	@Override
	public String getFileName() {
		return "collectorstrength";
	}

	@Override
	public int getCurrentEnergy() {
		return this.currentEnergy[3];
	}

	@Override
	public int getType() {
		return 3;
	}
	
	
}
