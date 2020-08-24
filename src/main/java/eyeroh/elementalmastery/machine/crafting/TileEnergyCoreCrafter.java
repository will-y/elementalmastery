package eyeroh.elementalmastery.machine.crafting;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class TileEnergyCoreCrafter extends TileEnergyAcceptorInventory{
	private int counter;
	private int maxProgress;
	
	public TileEnergyCoreCrafter() {
		super(new int[] {10000, 10000, 10000, 10000}, new int[] {100, 100, 100, 100}, 6, 200);
	}

	@Override
	public void doAction() {
		ItemStackHandler items = getItemStackHandler();
		for(int i = 0; i < 5; i++) {
			items.getStackInSlot(i).shrink(1);
		}
		if(items.getStackInSlot(5).isEmpty()) {
			items.insertItem(5, new ItemStack(ModItems.ENERGY_CORE_FRAGMENT.get()), false);
		} else {
			items.getStackInSlot(5).grow(1);
		}
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
	
	@Override
	public boolean getActive() {
		if(!super.getActive()) {
			return false;
		}
		return areItemsValid();
	}
	
	private boolean areItemsValid() {
		for(int i = 0; i < 4; i++) {
			if(!CoreCrafterUtilities.isItemValidOutside(getItemStackHandler().getStackInSlot(i))) {
				return false;
			}
		}
		if(!CoreCrafterUtilities.isItemValidInside(getItemStackHandler().getStackInSlot(4))) {
			return false;
		}
		
		return getItemStackHandler().getStackInSlot(5).getCount() != 64;
	}
}
