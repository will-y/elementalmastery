package eyeroh.elementalmastery.item.tool;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFarmer extends ItemAxe {

	public ItemFarmer(ToolMaterial material, String name, float damage, float speed) {
		super(material, 8.0f, -3.0f);
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
	public float getDestroySpeed(ItemStack stack, IBlockState state){
		Material material = state.getMaterial();
	    return material != Material.CAKE && material != Material.CACTUS && material != Material.WOOD && material != Material.CARPET && material != Material.CLOTH && material != Material.GOURD && material != Material.LEAVES && material != Material.PLANTS && material != Material.VINE && material !=Material.CLAY && material != Material.CRAFTED_SNOW && material != Material.SNOW && material != Material.SAND && material != Material.GRASS && material != Material.GROUND ? super.getDestroySpeed(stack, state) : this.efficiency;
	}
	
	private String mode = "Hoe";
	
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		 if(player.isSneaking() && world.isRemote) {
	        	if(mode == "Hoe") {
	        		mode = "Shovel";
	        	} else {
	        		mode = "Hoe";
	        	}
	        	 TextComponentTranslation component = new TextComponentTranslation("message.elementalmastery.farmer_mode", mode);
	             component.getStyle().setColor(TextFormatting.GREEN);
	             player.sendStatusMessage(component, true);
	        }
		 return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
	 }
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        
        if(player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
        	if(!player.isSneaking()) {
            	if(mode=="Hoe") {
            		int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(itemstack, player, worldIn, pos);
                    if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

                    IBlockState iblockstate = worldIn.getBlockState(pos);
                    Block block = iblockstate.getBlock();

                    if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
                    {
                        if (block == Blocks.GRASS || block == Blocks.GRASS_PATH)
                        {
                            this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                            return EnumActionResult.SUCCESS;
                        }

                        if (block == Blocks.DIRT)
                        {
                            switch ((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT))
                            {
                                case DIRT:
                                    this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                                    return EnumActionResult.SUCCESS;
                                case COARSE_DIRT:
                                    this.setBlock(itemstack, player, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                                    return EnumActionResult.SUCCESS;
                                default:
                                	return EnumActionResult.FAIL;
                            }
                        }
                    }

                    return EnumActionResult.PASS;
            	} else {
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
        	} else {
        		return EnumActionResult.PASS;
        	}
        } else {
        	return EnumActionResult.FAIL;
        }
    }
	
	protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player);
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
