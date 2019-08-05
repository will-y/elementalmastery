package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorFire extends TileCollector {
	private static ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.nuggetOpal), new ItemStack(ModItems.nuggetTopaz), new ItemStack(ModItems.nuggetRuby), new ItemStack(ModItems.nuggetSapphire)};
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

	public int getType() {
		return 1;
	}
}
