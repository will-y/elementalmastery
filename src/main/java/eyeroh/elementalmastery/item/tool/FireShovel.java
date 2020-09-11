package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Arrays;
import java.util.List;

public class FireShovel extends ShovelItem {
	public FireShovel() {
		super(ToolMaterials.FIRE, 8.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools).func_234689_a_());
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving, t -> {});
            if(state.getHarvestTool() == ToolType.SHOVEL || state.getHarvestTool() == null) {
                List<ItemStack> drops = state.getDrops(new LootContext.Builder((ServerWorld) world).withParameter(LootParameters.TOOL, stack).withParameter(LootParameters.field_237457_g_, entityLiving.getLookVec()));
                for (ItemStack itemStack : drops) {
                    Inventory inv = new Inventory(itemStack);
                    if (world.getRecipeManager().getRecipe(IRecipeType.SMELTING, inv, world).isPresent()) {
                        ItemStack smelted = world.getRecipeManager().getRecipe(IRecipeType.SMELTING, inv, world).get().getRecipeOutput();
                        world.destroyBlock(pos, false);
                        Block.spawnAsEntity(world, pos, smelted);
                    }
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
