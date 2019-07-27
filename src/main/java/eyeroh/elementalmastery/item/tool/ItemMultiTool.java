package eyeroh.elementalmastery.item.tool;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemMultiTool extends ItemFarmer{
	
	private float efficiency;
	private int toolHarvestLevel;

	public ItemMultiTool(ToolMaterial material, String name, float speed) {
		super(material, name, material.getDamageVsEntity(), speed);
		this.efficiency = material.getEfficiencyOnProperMaterial();
		this.toolHarvestLevel = material.getHarvestLevel();
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "spade", "axe", "sword");
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state){
	    return this.efficiency;
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState block) {
		int harvestLevel = block.getBlock().getHarvestLevel(block);
		
		if(harvestLevel <= toolHarvestLevel) {
			return true;
		} else {
			return false;
		}
	}
}