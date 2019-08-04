package eyeroh.elementalmastery.machine.crafting;

import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class TileEnergyCoreCrafter extends TileEnergyAcceptorInventory{
	private int counter;
	private int maxProgress;
	private ItemStackHandler itemStackHandler;
	
	public TileEnergyCoreCrafter() {
		super(new int[] {10000, 10000, 10000, 10000}, new int[] {100, 100, 100, 100}, 6, 200);
	}

	@Override
	public void doAction() {
	}
	
	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		if(slot < 4) {
			return CoreCrafterUtilities.isItemValidOutside(stack);
		} else if(slot == 4) {
			return CoreCrafterUtilities.isItemValidInside(stack);
		}
		return false;
	}
}
