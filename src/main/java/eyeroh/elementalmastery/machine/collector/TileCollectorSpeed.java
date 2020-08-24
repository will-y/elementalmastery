package eyeroh.elementalmastery.machine.collector;

public class TileCollectorSpeed extends TileCollector {

	public TileCollectorSpeed() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 4, getDefaultItemStackArray(), 100);
	}
	
	@Override
	public String getName() {
		return "Speed Collector";
	}
	
	@Override
	public String getFileName() {
		return "collectorspeed";
	}
	
	@Override
	public int getCurrentEnergy() {
		return this.currentEnergy[0];
	}

	@Override
	public int getEnergyType() {
		return 0;
	}
}
