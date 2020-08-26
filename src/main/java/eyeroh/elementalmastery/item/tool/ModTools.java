package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTools {

	public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalMastery.MODID);

	public static final RegistryObject<PickaxeItem> OPAL_PICKAXE = TOOLS.register("pickaxeopal",
			() -> new PickaxeItem(ToolMaterials.OPAL, 1, -2.8F, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<PickaxeItem> TOPAZ_PICKAXE = TOOLS.register("pickaxetopaz",
			() -> new PickaxeItem(ToolMaterials.TOPAZ, 1, -2.8F, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = TOOLS.register("pickaxeruby",
			() -> new PickaxeItem(ToolMaterials.RUBY, 1, -2.8F, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = TOOLS.register("pickaxesapphire",
			() -> new PickaxeItem(ToolMaterials.SAPPHIRE, 1, -2.8F, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<AxeItem> OPAL_AXE = TOOLS.register("axeopal",
			() -> new AxeItem(ToolMaterials.OPAL, 4, -3f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<AxeItem> TOPAZ_AXE = TOOLS.register("axetopaz",
			() -> new AxeItem(ToolMaterials.TOPAZ, 4, -3f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<AxeItem> RUBY_AXE = TOOLS.register("axeruby",
			() -> new AxeItem(ToolMaterials.RUBY, 4, -3f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<AxeItem> SAPPHIRE_AXE = TOOLS.register("axesapphire",
			() -> new AxeItem(ToolMaterials.SAPPHIRE, 4, -3f, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<SwordItem> OPAL_SWORD = TOOLS.register("swordopal",
			() -> new SwordItem(ToolMaterials.OPAL, 3, -2.4f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<SwordItem> TOPAZ_SWORD = TOOLS.register("swordtopaz",
			() -> new SwordItem(ToolMaterials.TOPAZ, 3, -2.4f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<SwordItem> RUBY_SWORD = TOOLS.register("swordruby",
			() -> new SwordItem(ToolMaterials.RUBY, 3, -2.4f, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = TOOLS.register("swordsapphire",
			() -> new SwordItem(ToolMaterials.SAPPHIRE, 3, -2.4f, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<HoeItem> OPAL_HOE = TOOLS.register("hoeopal",
			() -> new HoeItem(ToolMaterials.OPAL, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<HoeItem> TOPAZ_HOE = TOOLS.register("hoetopaz",
			() -> new HoeItem(ToolMaterials.TOPAZ, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<HoeItem> RUBY_HOE = TOOLS.register("hoeruby",
			() -> new HoeItem(ToolMaterials.RUBY, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<HoeItem> SAPPHIRE_HOE = TOOLS.register("hoesapphire",
			() -> new HoeItem(ToolMaterials.SAPPHIRE, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<ShovelItem> OPAL_SHOVEL = TOOLS.register("shovelopal",
			() -> new ShovelItem(ToolMaterials.OPAL, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ShovelItem> TOPAZ_SHOVEL = TOOLS.register("shoveltopaz",
			() -> new ShovelItem(ToolMaterials.TOPAZ, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ShovelItem> RUBY_SHOVEL = TOOLS.register("shovelruby",
			() -> new ShovelItem(ToolMaterials.RUBY, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));
	public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = TOOLS.register("shovelsapphire",
			() -> new ShovelItem(ToolMaterials.SAPPHIRE, -3, 0, new Item.Properties().group(CreativeTabs.tabGemTools)));

	public static final RegistryObject<ItemMiner> OPAL_MINER = TOOLS.register("mineropal",
			() -> new ItemMiner(ToolMaterials.OPAL, 1, -2.8f));
	public static final RegistryObject<ItemMiner> TOPAZ_MINER = TOOLS.register("minertopaz",
			() -> new ItemMiner(ToolMaterials.TOPAZ, 1, -2.8f));
	public static final RegistryObject<ItemMiner> RUBY_MINER = TOOLS.register("minerruby",
			() -> new ItemMiner(ToolMaterials.RUBY, 1, -2.8f));
	public static final RegistryObject<ItemMiner> SAPPHIRE_MINER = TOOLS.register("minersapphire",
			() -> new ItemMiner(ToolMaterials.SAPPHIRE, 1, -2.8f));
	public static final RegistryObject<ItemMiner> WOOD_MINER = TOOLS.register("minerwood",
			() -> new ItemMiner(ItemTier.WOOD, 1, -3f));
	public static final RegistryObject<ItemMiner> STONE_MINER = TOOLS.register("minerstone",
			() -> new ItemMiner(ItemTier.STONE, 1, -3f));
	public static final RegistryObject<ItemMiner> IRON_MINER = TOOLS.register("mineriron",
			() -> new ItemMiner(ItemTier.IRON, 1, -3f));
	public static final RegistryObject<ItemMiner> GOLD_MINER = TOOLS.register("minergold",
			() -> new ItemMiner(ItemTier.GOLD, 1, -3f));
	public static final RegistryObject<ItemMiner> DIAMOND_MINER = TOOLS.register("minerdiamond",
			() -> new ItemMiner(ItemTier.DIAMOND, 1, -3f));
	public static final RegistryObject<ItemMiner> NETHERITE_MINER = TOOLS.register("minernetherite",
			() -> new ItemMiner(ItemTier.NETHERITE, 1, -3f));

	public static final RegistryObject<ItemFarmer> OPAL_FARMER = TOOLS.register("farmeropal",
			() -> new ItemFarmer(ToolMaterials.OPAL, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> TOPAZ_FARMER = TOOLS.register("farmertopaz",
			() -> new ItemFarmer(ToolMaterials.TOPAZ, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> RUBY_FARMER = TOOLS.register("farmerruby",
			() -> new ItemFarmer(ToolMaterials.RUBY, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> SAPPHIRE_FARMER = TOOLS.register("farmersapphire",
			() -> new ItemFarmer(ToolMaterials.SAPPHIRE, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> WOOD_FARMER = TOOLS.register("farmerwood",
			() -> new ItemFarmer(ItemTier.WOOD, 1, -3f));
	public static final RegistryObject<ItemFarmer> STONE_FARMER = TOOLS.register("farmerstone",
			() -> new ItemFarmer(ItemTier.STONE, 1, -3f));
	public static final RegistryObject<ItemFarmer> IRON_FARMER = TOOLS.register("farmeriron",
			() -> new ItemFarmer(ItemTier.IRON, 1, -3f));
	public static final RegistryObject<ItemFarmer> GOLD_FARMER = TOOLS.register("farmergold",
			() -> new ItemFarmer(ItemTier.GOLD, 1, -3f));
	public static final RegistryObject<ItemFarmer> DIAMOND_FARMER = TOOLS.register("farmerdiamond",
			() -> new ItemFarmer(ItemTier.DIAMOND, 1, -3f));
	public static final RegistryObject<ItemFarmer> NETHERITE_FARMER = TOOLS.register("farmernetherite",
			() -> new ItemFarmer(ItemTier.NETHERITE, 1, -3f));

	public static final RegistryObject<ItemFarmer> OPAL_MULTI_TOOL = TOOLS.register("multiopal",
			() -> new ItemFarmer(ToolMaterials.OPAL, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> TOPAZ_MULTI_TOOL = TOOLS.register("multitopaz",
			() -> new ItemFarmer(ToolMaterials.TOPAZ, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> RUBY_MULTI_TOOL = TOOLS.register("multiruby",
			() -> new ItemFarmer(ToolMaterials.RUBY, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> SAPPHIRE_MULTI_TOOL = TOOLS.register("multisapphire",
			() -> new ItemFarmer(ToolMaterials.SAPPHIRE, 1, -2.8f));
	public static final RegistryObject<ItemFarmer> WOOD_MULTI_TOOL = TOOLS.register("multiwood",
			() -> new ItemFarmer(ItemTier.WOOD, 1, -3f));
	public static final RegistryObject<ItemFarmer> STONE_MULTI_TOOL = TOOLS.register("multistone",
			() -> new ItemFarmer(ItemTier.STONE, 1, -3f));
	public static final RegistryObject<ItemFarmer> IRON_MULTI_TOOL = TOOLS.register("multiiron",
			() -> new ItemFarmer(ItemTier.IRON, 1, -3f));
	public static final RegistryObject<ItemFarmer> GOLD_MULTI_TOOL = TOOLS.register("multigold",
			() -> new ItemFarmer(ItemTier.GOLD, 1, -3f));
	public static final RegistryObject<ItemFarmer> DIAMOND_MULTI_TOOL = TOOLS.register("multidiamond",
			() -> new ItemFarmer(ItemTier.DIAMOND, 1, -3f));
	public static final RegistryObject<ItemFarmer> NETHERITE_MULTI_TOOL = TOOLS.register("multinetherite",
			() -> new ItemFarmer(ItemTier.NETHERITE, 1, -3f));

	public static final RegistryObject<StrengthPickaxe> STRENGTH_PICKAXE = TOOLS.register("strengthpickaxe",
			StrengthPickaxe::new);
	public static final RegistryObject<StrengthAxe> STRENGTH_AXE = TOOLS.register("strengthaxe",
			StrengthAxe::new);
	public static final RegistryObject<StrengthShovel> STRENGTH_SHOVEL = TOOLS.register("strengthshovel",
			StrengthShovel::new);
	public static final RegistryObject<StrengthSword> STRENGTH_SWORD = TOOLS.register("strengthsword",
			StrengthSword::new);

	public static final RegistryObject<SpeedSword> SPEED_SWORD = TOOLS.register("speedsword",
			SpeedSword::new);

	public static final RegistryObject<FirePickaxe> FIRE_PICKAXE = TOOLS.register("firepickaxe",
			FirePickaxe::new);
	public static final RegistryObject<FireAxe> FIRE_AXE = TOOLS.register("fireaxe",
			FireAxe::new);
	public static final RegistryObject<FireShovel> FIRE_SHOVEL = TOOLS.register("fireshovel",
			FireShovel::new);
	public static final RegistryObject<FireSword> FIRE_SWORD = TOOLS.register("firesword",
			FireSword::new);

	public static final RegistryObject<HealSword> HEAL_SWORD = TOOLS.register("healsword",
			HealSword::new);
	public static final RegistryObject<HealAxe> HEAL_AXE = TOOLS.register("healaxe",
			HealAxe::new);

	public static final RegistryObject<ItemLinker> LINKER = TOOLS.register("linker", ItemLinker::new);
}
