package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorFire extends TileCollector {
	private static ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.NUGGET_OPAL.get()), new ItemStack(ModItems.NUGGET_TOPAZ.get()), new ItemStack(ModItems.NUGGET_RUBY.get()), new ItemStack(ModItems.NUGGET_SAPPHIRE.get())};
	public TileCollectorFire() {
		super(new int[] {0, 10000, 0, 0}, new int[] {0, 100, 0, 0}, 4, itemsGenerated, 200);
	}
	
	@Override
	public String getName() {
		return "Fire Collector";
	}
	
	@Override
	public String getFileName() {
		return "collectorfire";
	}
	
	@Override
	public int getCurrentEnergy() {
		return this.currentEnergy[1];
	}

	@Override
	public int getEnergyType() {
		return 1;
	}
}
