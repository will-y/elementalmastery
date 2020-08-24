package eyeroh.elementalmastery.item.armor;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ArmorMaterials implements IArmorMaterial {
    OPAL(ElementalMastery.MODID + ":armoropal", 25, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    TOPAZ(ElementalMastery.MODID + ":armortopaz", 25, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    RUBY(ElementalMastery.MODID + ":armorruby", 25, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    SAPPHIRE(ElementalMastery.MODID + ":armorsapphire", 25, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    SPEED(ElementalMastery.MODID + ":armoropal", 40, new int[] {6, 12, 14, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModBlocks.OPAL_BLOCK.get());}, 0.0f),
    FIRE(ElementalMastery.MODID + ":armortopaz", 25, new int[] {6, 12, 14, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    HEAL(ElementalMastery.MODID + ":armorruby", 25, new int[] {6, 12, 14, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f),
    STRENGTH(ElementalMastery.MODID + ":armorsapphire", 25, new int[] {6, 12, 14, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f,
            () -> {return Ingredient.fromItems(ModItems.GEM_OPAL.get());}, 0.0f);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor; //Durability, Iron=15, Diamond=33, Gold=7, Leather=5
    private final int[] damageReductionAmountArray; //Armor Bar Protection, 1 = 1/2 armor bar
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness; //Increases Protection, 0.0F=Iron/Gold/Leather, 2.0F=Diamond, 3.0F=Netherite
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance; //1.0F=No Knockback, 0.0F=Disabled

    ArmorMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
                   SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return this.knockbackResistance;
    }
}
