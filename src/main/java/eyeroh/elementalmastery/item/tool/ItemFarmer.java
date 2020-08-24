package eyeroh.elementalmastery.item.tool;

import java.util.Set;

import com.google.common.collect.Sets;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ItemFarmer extends AxeItem {

	public ItemFarmer(IItemTier material, float damage, float speed, Item.Properties properties) {
		super(material, damage, speed, properties
                .addToolType(ToolType.AXE, material.getHarvestLevel())
                .addToolType(ToolType.HOE, material.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, material.getHarvestLevel())
                .group(CreativeTabs.tabGemTools));
	}

	public ItemFarmer(IItemTier material, float damage, float speed) {
	    this(material, damage, speed, new Item.Properties());
    }
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.SOUL_SAND, Blocks.GRASS_PATH);

	
	@Override
	public boolean canHarvestBlock(BlockState block) {
		return EFFECTIVE_ON.contains(block.getBlock()) || super.canHarvestBlock(block);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state){
		Material material = state.getMaterial();
	    return material != Material.CAKE && material != Material.CACTUS && material != Material.WOOD && material != Material.CARPET && material != Material.WOOL && material != Material.GOURD && material != Material.LEAVES && material != Material.PLANTS && material != Material.OCEAN_PLANT && material !=Material.CLAY && material != Material.SNOW_BLOCK && material != Material.SNOW && material != Material.SAND && material != Material.SEA_GRASS && material != Material.EARTH ? super.getDestroySpeed(stack, state) : this.efficiency;
	}
	
	private String mode = "Hoe";
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {
		 if(player.isSneaking() && world.isRemote) {
	        	if(mode == "Hoe") {
	        		mode = "Shovel";
	        	} else {
	        		mode = "Hoe";
	        	}
	        	 TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.farmer_mode", mode);
	             component.getStyle().func_240720_a_(TextFormatting.GREEN);
	             player.sendStatusMessage(component, true);
	        }
		 return new ActionResult<ItemStack>(ActionResultType.PASS, player.getHeldItem(handIn));
	 }
	
	@Override
    public ActionResultType onItemUse(ItemUseContext context) {
	    PlayerEntity player = context.getPlayer();
	    Hand hand = context.getHand();
	    World world = context.getWorld();
        ItemStack itemstack = player.getHeldItem(hand);
        BlockPos pos = context.getPos();
        Direction facing = context.getFace();
        
        if(player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
        	if(!player.isSneaking()) {
            	if(mode=="Hoe") {
                    int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
                    if (hook != 0) {
                        return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
                    }
                    if (context.getFace() != Direction.DOWN && world.isAirBlock(pos.up())) {
                        BlockState blockstate = world.getBlockState(pos).getToolModifiedState(world, pos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
                        if (blockstate != null) {
                            PlayerEntity playerentity = context.getPlayer();
                            world.playSound(playerentity, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            if (!world.isRemote) {
                                world.setBlockState(pos, blockstate, 11);
                                if (playerentity != null) {
                                    context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                                        p_220043_1_.sendBreakAnimation(context.getHand());
                                    });
                                }
                            }

                            return ActionResultType.func_233537_a_(world.isRemote);
                        }
                    }

                    return ActionResultType.PASS;
            	} else {
            		BlockState blockstate = world.getBlockState(pos);

                    if (context.getFace() == Direction.DOWN) {
                        return ActionResultType.PASS;
                    } else {
                        PlayerEntity playerentity = context.getPlayer();
                        BlockState blockstate1 = blockstate.getToolModifiedState(world, pos, playerentity, context.getItem(), net.minecraftforge.common.ToolType.SHOVEL);
                        BlockState blockstate2 = null;
                        if (blockstate1 != null && world.isAirBlock(pos.up())) {
                            world.playSound(playerentity, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            blockstate2 = blockstate1;
                        } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
                            if (!world.isRemote()) {
                                world.playEvent((PlayerEntity)null, 1009, pos, 0);
                            }

                            CampfireBlock.func_235475_c_(world, pos, blockstate);
                            blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
                        }

                        if (blockstate2 != null) {
                            if (!world.isRemote) {
                                world.setBlockState(pos, blockstate2, 11);
                                if (playerentity != null) {
                                    context.getItem().damageItem(1, playerentity, (p_220041_1_) -> {
                                        p_220041_1_.sendBreakAnimation(context.getHand());
                                    });
                                }
                            }

                            return ActionResultType.func_233537_a_(world.isRemote);
                        } else {
                            return ActionResultType.PASS;
                        }
                    }
        	
            	}
        	} else {
        		return ActionResultType.PASS;
        	}
        } else {
        	return ActionResultType.FAIL;
        }
    }
	
	protected void setBlock(ItemStack stack, PlayerEntity player, World worldIn, BlockPos pos, BlockState state)
    {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player, t -> {});
        }
    }
}
