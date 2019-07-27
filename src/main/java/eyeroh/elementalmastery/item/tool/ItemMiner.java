package eyeroh.elementalmastery.item.tool;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMiner extends ItemPickaxe{
	
	public ItemMiner(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.CONCRETE_POWDER);
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "spade");
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState block) {
		return EFFECTIVE_ON.contains(block.getBlock()) ? true : super.canHarvestBlock(block);
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state){
		Material material = state.getMaterial();
	    return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK && material !=Material.CLAY && material != Material.CRAFTED_SNOW && material != Material.SNOW && material != Material.SAND && material != Material.GRASS && material != Material.GROUND ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS)
            {
                IBlockState iblockstate1 = Blocks.GRASS_PATH.getDefaultState();
                worldIn.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!worldIn.isRemote)
                {
                    worldIn.setBlockState(pos, iblockstate1, 11);
                    itemstack.damageItem(1, player);
                }

                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.PASS;
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
