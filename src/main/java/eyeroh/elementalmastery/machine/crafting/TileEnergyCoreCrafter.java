package eyeroh.elementalmastery.machine.crafting;

import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraftforge.items.ItemStackHandler;

public class TileEnergyCoreCrafter extends TileEnergyAcceptor{
	private int counter;
	private int maxProgress;
	private ItemStackHandler itemStackHandler;
	
	public TileEnergyCoreCrafter(int[] storage, int[] usage, int size) {
		super(storage, usage, size);
	}

	@Override
	public void actionPerTick() {
		// TODO Auto-generated method stub
		
	}
	
	

}
