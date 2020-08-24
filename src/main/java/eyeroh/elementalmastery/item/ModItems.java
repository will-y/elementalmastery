package eyeroh.elementalmastery.item;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalMastery.MODID);

	// Items
	public static final RegistryObject<Item> GEM_OPAL = ITEMS.register("gemopal", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> GEM_TOPAZ = ITEMS.register("gemtopaz", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> GEM_RUBY = ITEMS.register("gemruby", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> GEM_SAPPHIRE = ITEMS.register("gemsapphire", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> TOOL_BINDER = ITEMS.register("toolbinder", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> ENERGY_CORE_OPAL = ITEMS.register("energycoreopal", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_TOPAZ = ITEMS.register("energycoretopaz", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_RUBY = ITEMS.register("energycoreruby", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_SAPPHIRE = ITEMS.register("energycoresapphire", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_MULTI = ITEMS.register("energycoremulti", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> ENERGY_CORE_OPAL_ACTIVE = ITEMS.register("energycoreopal_active", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_TOPAZ_ACTIVE = ITEMS.register("energycoretopaz_active", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_RUBY_ACTIVE = ITEMS.register("energycoreruby_active", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_SAPPHIRE_ACTIVE = ITEMS.register("energycoresapphire_active", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> ENERGY_CORE_MULTI_ACTIVE = ITEMS.register("energycoremulti_active", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> ENERGY_CORE_FRAGMENT = ITEMS.register("energycorefragment", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> DUST_OPAL = ITEMS.register("dustopal", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_TOPAZ = ITEMS.register("dusttopaz", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_RUBY = ITEMS.register("dustruby", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_SAPPHIRE = ITEMS.register("dustsapphire", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_MULTI = ITEMS.register("dustmulti", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> DUST_OPAL_SMALL = ITEMS.register("dustopalsmall", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_TOPAZ_SMALL = ITEMS.register("dusttopazsmall", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_RUBY_SMALL = ITEMS.register("dustrubysmall", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> DUST_SAPPHIRE_SMALL = ITEMS.register("dustsapphiresmall", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> SMALL_HEART = ITEMS.register("smallheart", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	public static final RegistryObject<Item> CELL_OPAL = ITEMS.register("cellopal", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> CELL_TOPAZ = ITEMS.register("celltopaz", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> CELL_RUBY = ITEMS.register("cellruby", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> CELL_SAPPHIRE = ITEMS.register("cellsapphire", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

	// Item Blocks
	public static final RegistryObject<Item> OPAL_BLOCK_ITEM = ITEMS.register("blockopal", () -> new BlockItem(ModBlocks.OPAL_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> TOPAZ_BLOCK_ITEM = ITEMS.register("blocktopaz", () -> new BlockItem(ModBlocks.TOPAZ_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("blockruby", () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("blocksapphire", () -> new BlockItem(ModBlocks.SAPPHIRE_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));

	public static final RegistryObject<Item> OPAL_ORE_ITEM = ITEMS.register("oreopal", () -> new BlockItem(ModBlocks.OPAL_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> TOPAZ_ORE_ITEM = ITEMS.register("oretopaz", () -> new BlockItem(ModBlocks.TOPAZ_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("oreruby", () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("oresapphire", () -> new BlockItem(ModBlocks.SAPPHIRE_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
}
