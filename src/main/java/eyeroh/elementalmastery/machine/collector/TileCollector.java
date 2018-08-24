package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.item.ItemStack;

public class TileCollector extends TileEnergyAcceptor {
	
	public int counter = 0;
	public int timeBetweenCollect;
	public ItemStack[] collectorItems;
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items) {
		super(storage, usage, invSize);
		this.collectorItems = items;
	}
	
	@Override
	public void actionPerTick() {
		int itemNum = rand.nextInt(collectorItems.length);
	}
}
