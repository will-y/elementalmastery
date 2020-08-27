package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ToolMaterials implements IItemTier {

    OPAL(2, 550, 7.0f, 2.5f, 10, () -> {
        return Ingredient.fromItems(ModItems.GEM_OPAL.get());
    }),

    TOPAZ(2, 550, 7.0f, 2.5f, 10, () -> {
        return Ingredient.fromItems(ModItems.GEM_TOPAZ.get());
    }),

    RUBY(2, 550, 7.0f, 2.5f, 10, () -> {
        return Ingredient.fromItems(ModItems.GEM_RUBY.get());
    }),

    SAPPHIRE(2, 550, 7.0f, 2.5f, 10, () -> {
        return Ingredient.fromItems(ModItems.GEM_SAPPHIRE.get());
    }),

    SPEED(2, 750, 9.0f, 2.5f, 10, () -> {
        return Ingredient.fromItems(ModBlocks.OPAL_BLOCK_ITEM.get());
    }),

    FIRE(2, 1000, 7.0f, 3.0f, 10, () -> {
        return Ingredient.fromItems(ModBlocks.OPAL_BLOCK_ITEM.get());
    }),

    HEAL(2, 1000, 7.0f, 3.0f, 10, () -> {
        return Ingredient.fromItems(ModBlocks.OPAL_BLOCK_ITEM.get());
    }),

    STRENGTH(2, 1250, 6.0f, 3.5f, 10, () -> {
        return Ingredient.fromItems(ModBlocks.OPAL_BLOCK_ITEM.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ToolMaterials (int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
