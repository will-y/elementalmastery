package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeedPickaxe extends PickaxeItem {
    public SpeedPickaxe() {
        super(ToolMaterials.SPEED, 4, 2.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving, t -> {});
            if (stack.canHarvestBlock(state)) {
                if (world.rand.nextInt(100) >= 95) {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 3));
                    entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 1));
                }
            }
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
