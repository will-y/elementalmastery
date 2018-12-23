package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.item.ItemStack;

public class TileCollector extends TileEnergyAcceptor {
	
	public int timeBetweenCollect;
	public ItemStack[] collectorItems;
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items, int maxCounter) {
		super(storage, usage, invSize);
		this.collectorItems = items;
		this.timeBetweenCollect = maxCounter;
	}
	
	@Override
	public void actionPerTick() {
		if(counter >= timeBetweenCollect) {
			int itemNum = rand.nextInt(collectorItems.length);
			addItem(collectorItems[itemNum], itemNum);
			counter = 0;
		}
		counter++;
	}
	
	public void addItem(ItemStack item, int slot) {
		getItemStackHandler().insertItem(slot, item, false);
	}
	
	public static ItemStack[] getDefaultItemStackArray() {
		return new ItemStack[] {new ItemStack(ModItems.dustOpalSmall), new ItemStack(ModItems.dustTopazSmall), new ItemStack(ModItems.dustRubySmall), new ItemStack(ModItems.dustSapphireSmall)};
	}
}