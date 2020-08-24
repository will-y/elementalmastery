package eyeroh.elementalmastery.item.tool;

import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class ItemMultiTool extends ItemFarmer {
	
	private float efficiency;
	private int toolHarvestLevel;

	public ItemMultiTool(IItemTier material, float speed) {
		super(material, material.getAttackDamage(), speed, new Item.Properties()
				.addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
		efficiency = material.getEfficiency();
		toolHarvestLevel = material.getHarvestLevel();
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state){
	    return this.efficiency;
	}
	
	@Override
	public boolean canHarvestBlock(BlockState block) {
		int harvestLevel = block.getBlock().getHarvestLevel(block);

		return harvestLevel <= toolHarvestLevel;
	}
}