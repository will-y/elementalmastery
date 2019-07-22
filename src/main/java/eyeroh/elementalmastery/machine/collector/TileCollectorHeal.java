package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;

public class TileCollectorHeal extends TileCollector {
	
	private ItemStack[] itemsGenerated = new ItemStack[] {new ItemStack(ModItems.dustOpalSmall), new ItemStack(ModItems.dustTopazSmall), new ItemStack(ModItems.dustRubySmall), new ItemStack(ModItems.dustSapphireSmall), new ItemStack(ModItems.smallHeart)};
	
	
	public TileCollectorHeal() {
		super(new int[] {10000, 0, 0, 0}, new int[] {100, 0, 0, 0}, 5, getDefaultItemStackArray(), 200);
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
	public int getType() {
		return 3;
	}
}
