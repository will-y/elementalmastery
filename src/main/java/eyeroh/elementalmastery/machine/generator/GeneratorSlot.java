package eyeroh.elementalmastery.machine.generator;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GeneratorSlot extends SlotItemHandler {
	public Item[] itemsAllowd;
	
	public GeneratorSlot(IItemHandler inventory, int index, int x, int y, Item[] itemsAllowd) {
		super(inventory, index, x, y);
		this.itemsAllowd = itemsAllowd;
	}
	
	@Override
	public boolean isItemValid(@Nullable ItemStack stack) {
		ItemStack itemStack1 = new ItemStack(itemsAllowd[0]);
		ItemStack itemStack2 = new ItemStack(itemsAllowd[1]);
		if (itemStack1.isItemEqual(stack) || itemStack2.isItemEqual(stack)) {
			return true;
		}
		return false;
	}
}