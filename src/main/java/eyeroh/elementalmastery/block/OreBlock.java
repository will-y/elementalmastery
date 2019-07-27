package eyeroh.elementalmastery.block;

import java.util.Random;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OreBlock extends Block{
	public OreBlock(String name) {
		super(Material.ROCK);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 2);
		setUnlocalizedName(ElementalMastery.MODID + "." + name);
		setRegistryName(name);
		this.setCreativeTab(ModBlocks.tabGemBlocks);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (this == ModBlocks.oreopal)
        {
            return ModItems.gemOpal;
        }
        else if (this == ModBlocks.oretopaz)
        {
            return ModItems.gemTopaz;
        }
        else if (this == ModBlocks.oreruby)
        {
            return ModItems.gemRuby;
        }
        else if (this == ModBlocks.oresapphire)
        {
            return ModItems.gemSapphire;
        } else {
        	return null;
        }
    }
	
	@Override
	 public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 6) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
	 @Override
	    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	    {
	        Random rand = world instanceof World ? ((World)world).rand : new Random();
	        return MathHelper.getInt(rand, 3, 5);
	    }
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
