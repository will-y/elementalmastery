package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorHeal extends TileCollector {
	
	private static ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.DUST_OPAL_SMALL.get()), new ItemStack(ModItems.DUST_TOPAZ_SMALL.get()), new ItemStack(ModItems.DUST_RUBY_SMALL.get()), new ItemStack(ModItems.DUST_SAPPHIRE_SMALL.get()), new ItemStack(ModItems.SMALL_HEART.get())};
	
	
	public TileCollectorHeal() {
		super(new int[] {0, 0, 10000, 0}, new int[] {0, 0, 100, 0}, 5, itemsGenerated, 200);
	}
	
	@Override
	public String getName() {
		return "Healing Collector";
	}
	
	@Override
	public String getFileName() {
		return "collectorheal";
	}

	@Override
	public int getCurrentEnergy() {
		return this.currentEnergy[2];
	}

	@Override
	public int getEnergyType() {
		return 2;
	}
}
