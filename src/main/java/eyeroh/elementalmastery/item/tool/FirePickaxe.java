package eyeroh.elementalmastery.item.tool;

import java.util.List;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.util.datafix.fixes.FurnaceRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class FirePickaxe extends PickaxeItem {
	public FirePickaxe() {
		super(ToolMaterials.FIRE, 4, 2.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving, t -> {});
            
            if(this.canHarvestBlock(stack, state)) {
                List<ItemStack> drops = state.getDrops(new LootContext.Builder((ServerWorld) world).withParameter(LootParameters.TOOL, stack).withParameter(LootParameters.field_237457_g_, entityLiving.func_241205_ce_()));
				for (ItemStack itemStack : drops) {
                    world.getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(itemStack), world).ifPresent((furnaceRecipe) -> {
                        ItemStack smelted = furnaceRecipe.getRecipeOutput();
                        world.destroyBlock(pos, false);
                        Block.spawnAsEntity(world, pos, smelted);
                    });
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
