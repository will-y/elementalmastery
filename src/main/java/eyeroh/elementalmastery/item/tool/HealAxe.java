package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class HealAxe extends AxeItem {
	public HealAxe() {
		super(ToolMaterials.HEAL, 7.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	  @Override
	  public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity player = context.getPlayer();
		World world = context.getWorld();
		ItemStack itemStack = player.getHeldItem(context.getHand());
		  
		  if (applyBonemeal(itemStack, context.getWorld(), context.getPos(), player)) {
              if (!world.isRemote)
              {
                  world.playEvent(2005, context.getPos(), 0);
              }
          }
		  return ActionResultType.SUCCESS;
	  }
	  
	  public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, PlayerEntity player) {
	        BlockState blockstate = worldIn.getBlockState(target);

	        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, blockstate, stack);
	        if (hook != 0) return hook > 0;

	        if (blockstate.getBlock() instanceof IGrowable)
	        {
	            IGrowable igrowable = (IGrowable) blockstate.getBlock();

	            if (igrowable.canGrow(worldIn, target, blockstate, worldIn.isRemote))
	            {
	                if (!worldIn.isRemote)
	                {
	                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, blockstate))
	                    {
	                        igrowable.grow(ServerLifecycleHooks.getCurrentServer().func_241755_D_(), worldIn.rand, target, blockstate);
	                        stack.damageItem(5, player, t -> {});
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
