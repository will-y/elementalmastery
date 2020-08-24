package eyeroh.elementalmastery.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GemBlock extends Block {
	public GemBlock() {
		super(Block.Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.sound(SoundType.STONE)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE));

//		setUnlocalizedName(ElementalMastery.MODID + "." + name);
//		setRegistryName(name);
//		this.setCreativeTab(ModBlocks.tabGemBlocks);
	}
	
//	@SideOnly(Side.CLIENT)
//    public void initModel() {
//        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
//    }
}
