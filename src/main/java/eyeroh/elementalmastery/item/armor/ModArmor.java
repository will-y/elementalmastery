package eyeroh.elementalmastery.item.armor;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmor {
	public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalMastery.MODID);

	public static final RegistryObject<ArmorItem> OPAL_HELMET = ARMOR.register("helmetopal",
			() -> new ArmorItem(ArmorMaterials.OPAL, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> OPAL_CHESTPLATE = ARMOR.register("chestplateopal",
			() -> new ArmorItem(ArmorMaterials.OPAL, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> OPAL_LEGGINGS = ARMOR.register("leggingsopal",
			() -> new ArmorItem(ArmorMaterials.OPAL, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> OPAL_BOOTS = ARMOR.register("bootsopal",
			() -> new ArmorItem(ArmorMaterials.OPAL, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<ArmorItem> TOPAZ_HELMET = ARMOR.register("helmettopaz",
			() -> new ArmorItem(ArmorMaterials.TOPAZ, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> TOPAZ_CHESTPLATE = ARMOR.register("chestplatetopaz",
			() -> new ArmorItem(ArmorMaterials.TOPAZ, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> TOPAZ_LEGGINGS = ARMOR.register("leggingstopaz",
			() -> new ArmorItem(ArmorMaterials.TOPAZ, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> TOPAZ_BOOTS = ARMOR.register("bootstopaz",
			() -> new ArmorItem(ArmorMaterials.TOPAZ, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<ArmorItem> RUBY_HELMET = ARMOR.register("helmetruby",
			() -> new ArmorItem(ArmorMaterials.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ARMOR.register("chestplateruby",
			() -> new ArmorItem(ArmorMaterials.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ARMOR.register("leggingsruby",
			() -> new ArmorItem(ArmorMaterials.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> RUBY_BOOTS = ARMOR.register("bootsruby",
			() -> new ArmorItem(ArmorMaterials.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<ArmorItem> SAPPHIRE_HELMET = ARMOR.register("helmetsapphire",
			() -> new ArmorItem(ArmorMaterials.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> SAPPHIRE_CHESTPLATE = ARMOR.register("chestplatesapphire",
			() -> new ArmorItem(ArmorMaterials.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> SAPPHIRE_LEGGINGS = ARMOR.register("leggingssapphire",
			() -> new ArmorItem(ArmorMaterials.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ArmorItem> SAPPHIRE_BOOTS = ARMOR.register("bootssapphire",
			() -> new ArmorItem(ArmorMaterials.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<SpecialArmor> SPEED_HELMET = ARMOR.register("helmetspeed",
			() -> new SpecialArmor(ArmorMaterials.SPEED, EquipmentSlotType.HEAD));
	public static final RegistryObject<SpecialArmor> SPEED_CHESTPLATE = ARMOR.register("chestplatespeed",
			() -> new SpecialArmor(ArmorMaterials.SPEED, EquipmentSlotType.CHEST));
	public static final RegistryObject<SpecialArmor> SPEED_LEGGINGS = ARMOR.register("leggingsspeed",
			() -> new SpecialArmor(ArmorMaterials.SPEED, EquipmentSlotType.LEGS));
	public static final RegistryObject<SpecialArmor> SPEED_BOOTS = ARMOR.register("bootsspeed",
			() -> new SpecialArmor(ArmorMaterials.SPEED, EquipmentSlotType.FEET));

	public static final RegistryObject<SpecialArmor> FIRE_HELMET = ARMOR.register("helmetfire",
			() -> new SpecialArmor(ArmorMaterials.FIRE, EquipmentSlotType.HEAD));
	public static final RegistryObject<SpecialArmor> FIRE_CHESTPLATE = ARMOR.register("chestplatefire",
			() -> new SpecialArmor(ArmorMaterials.FIRE, EquipmentSlotType.CHEST));
	public static final RegistryObject<SpecialArmor> FIRE_LEGGINGS = ARMOR.register("leggingsfire",
			() -> new SpecialArmor(ArmorMaterials.FIRE, EquipmentSlotType.LEGS));
	public static final RegistryObject<SpecialArmor> FIRE_BOOTS = ARMOR.register("bootsfire",
			() -> new SpecialArmor(ArmorMaterials.FIRE, EquipmentSlotType.FEET));

	public static final RegistryObject<SpecialArmor> HEAL_HELMET = ARMOR.register("helmetheal",
			() -> new SpecialArmor(ArmorMaterials.HEAL, EquipmentSlotType.HEAD));
	public static final RegistryObject<SpecialArmor> HEAL_CHESTPLATE = ARMOR.register("chestplateheal",
			() -> new SpecialArmor(ArmorMaterials.HEAL, EquipmentSlotType.CHEST));
	public static final RegistryObject<SpecialArmor> HEAL_LEGGINGS = ARMOR.register("leggingsheal",
			() -> new SpecialArmor(ArmorMaterials.HEAL, EquipmentSlotType.LEGS));
	public static final RegistryObject<SpecialArmor> HEAL_BOOTS = ARMOR.register("bootsheal",
			() -> new SpecialArmor(ArmorMaterials.HEAL, EquipmentSlotType.FEET));

	public static final RegistryObject<SpecialArmor> STRENGTH_HELMET = ARMOR.register("helmetstrength",
			() -> new SpecialArmor(ArmorMaterials.STRENGTH, EquipmentSlotType.HEAD));
	public static final RegistryObject<SpecialArmor> STRENGTH_CHESTPLATE = ARMOR.register("chestplatestrength",
			() -> new SpecialArmor(ArmorMaterials.STRENGTH, EquipmentSlotType.CHEST));
	public static final RegistryObject<SpecialArmor> STRENGTH_LEGGINGS = ARMOR.register("leggingsstrength",
			() -> new SpecialArmor(ArmorMaterials.STRENGTH, EquipmentSlotType.LEGS));
	public static final RegistryObject<SpecialArmor> STRENGTH_BOOTS = ARMOR.register("bootsstrength",
			() -> new SpecialArmor(ArmorMaterials.STRENGTH, EquipmentSlotType.FEET));

}
