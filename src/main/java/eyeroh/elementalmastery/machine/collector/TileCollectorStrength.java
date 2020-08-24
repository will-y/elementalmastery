package eyeroh.elementalmastery.machine.collector;

import net.minecraft.item.ItemStack;

public class TileCollectorStrength extends TileCollector {

	public TileCollectorStrength() {
		super(new int[] {0, 0, 0, 10000}, new int[] {0, 0, 0, 100}, 8, getDefaultItemStackArray(), 200);
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
	public int getEnergyType() {
		return 3;
	}
	
	
}
