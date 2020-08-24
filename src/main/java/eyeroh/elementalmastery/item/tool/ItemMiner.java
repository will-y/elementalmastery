package eyeroh.elementalmastery.item.tool;

import java.util.Set;

import com.google.common.collect.Sets;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ItemMiner extends PickaxeItem {
	
	public ItemMiner(IItemTier material, int damage, float speed) {
        super(material, damage, speed, new Item.Properties()
                .addToolType(ToolType.PICKAXE, material.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, material.getHarvestLevel())
                .group(CreativeTabs.tabGemTools));
	}

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.SOUL_SAND, Blocks.GRASS_PATH);

	
	@Override
	public boolean canHarvestBlock(BlockState block) {
		return EFFECTIVE_ON.contains(block.getBlock()) ? true : super.canHarvestBlock(block);
	}
	
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state){
		Material material = state.getMaterial();
	    return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK && material !=Material.CLAY && material != Material.SNOW_BLOCK && material != Material.SNOW && material != Material.SAND && material != Material.EARTH ? super.getDestroySpeed(stack, state) : this.efficiency;
	}

    public ActionResultType onItemUse(ItemUseContext context) {
	    PlayerEntity player = context.getPlayer();
	    Hand hand = context.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        Direction facing = context.getFace();
        BlockPos pos = context.getPos();
        World world = context.getWorld();

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return ActionResultType.FAIL;
        }
        else
        {
            BlockState blockstate = world.getBlockState(pos);
            Block block = blockstate.getBlock();

            if (facing != Direction.DOWN && world.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS)
            {
                BlockState blockstate1 = Blocks.GRASS_PATH.getDefaultState();
                world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!world.isRemote)
                {
                    world.setBlockState(pos, blockstate1, 11);
                    itemstack.damageItem(1, player, t -> {});
                }

                return ActionResultType.SUCCESS;
            }
            else
            {
                return ActionResultType.PASS;
            }
        }
    }
}
