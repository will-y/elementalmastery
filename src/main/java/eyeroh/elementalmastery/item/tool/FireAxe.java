package eyeroh.elementalmastery.item.tool;

import java.util.Random;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireAxe extends AxeItem {
	public FireAxe() {
		super(ToolMaterials.FIRE, 8.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving, t -> {});
            if(this.canHarvestBlock(stack, state)) {
            	if (stack.getItem().getTags().contains(ItemTags.LOGS)) {
					ItemStack itemStack2 = new ItemStack(Items.CHARCOAL, 1);
					world.destroyBlock(pos, false);
					ItemEntity unsmelted = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
					world.addEntity(unsmelted);
					return true;
				}
            }
        }
        return false;
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});

        Random rand = new Random();
        if(rand.nextInt(10) > 6) {
        	target.setFire(10);
        }
        return true;
    }
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

    @Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}
