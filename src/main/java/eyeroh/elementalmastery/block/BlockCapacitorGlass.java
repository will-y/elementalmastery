package eyeroh.elementalmastery.block;

import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockCapacitorGlass extends GlassBlock {

	public BlockCapacitorGlass() {
		super(Block.Properties.create(Material.GLASS)
				.hardnessAndResistance(5.0f, 6.0f)
				.sound(SoundType.GLASS)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE));
		//setUnlocalizedName(ElementalMastery.MODID + ".capacitorglass");
		//setRegistryName("capacitorglass");
		//this.setCreativeTab(ModMachines.tabGemMachines);
	}
	
//	@SideOnly(Side.CLIENT)
//    public void initModel() {
//        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
//    }

}
