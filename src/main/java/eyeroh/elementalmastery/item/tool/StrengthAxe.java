package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StrengthAxe extends AxeItem {
	public StrengthAxe() {
		super(ToolMaterials.STRENGTH, 8.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

    @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving, t -> {});
            
            checkForWood(pos, world, entityLiving, stack);
            
        }

        return true;
    }
	
	private void checkForWood(BlockPos pos, World world, LivingEntity entityLiving, ItemStack stack) {
		for (int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				for(int k = -1; k < 2; k++) {
					if(world.getBlockState(pos.add(i, j, k)).getBlock().getTags().contains(ItemTags.LOGS.func_230234_a_()) ) {
						if(stack.getMaxDamage() - stack.getDamage() > 0) {
							world.destroyBlock(pos.add(i, j, k), true);
							stack.damageItem(1, entityLiving, t -> {});
							checkForWood(pos.add(i, j, k), world, entityLiving, stack);
						}
					}
				}
			}
		}
	}
}
