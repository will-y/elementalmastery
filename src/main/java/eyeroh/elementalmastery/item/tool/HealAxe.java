package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HealAxe extends ItemAxe {
	public HealAxe() {
		super(ModTools.TOOLMATERIALHEAL, 8.0f, -3.0f);
		this.setRegistryName("healaxe");
		this.setUnlocalizedName(ElementalMastery.MODID + ".healaxe");
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	  public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		  ItemStack itemstack = player.getHeldItem(hand);
		  
		  if (applyBonemeal(itemstack, worldIn, pos, player, hand)) {
              if (!worldIn.isRemote)
              {
                  worldIn.playEvent(2005, pos, 0);
              }

              return EnumActionResult.SUCCESS;
          }
		  return EnumActionResult.SUCCESS;
	  }
	  
	  public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, @javax.annotation.Nullable EnumHand hand) {
	        IBlockState iblockstate = worldIn.getBlockState(target);

	        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
	        if (hook != 0) return hook > 0;

	        if (iblockstate.getBlock() instanceof IGrowable)
	        {
	            IGrowable igrowable = (IGrowable)iblockstate.getBlock();

	            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
	            {
	                if (!worldIn.isRemote)
	                {
	                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
	                    {
	                        igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
	                        stack.damageItem(5, player);
	                    }
	                }

	                return true;
	            }
	        }

	        return false;
	    }
	  
	  @Override
		public boolean hasEffect(ItemStack itemstack) {
	        return true;
	    }
}
