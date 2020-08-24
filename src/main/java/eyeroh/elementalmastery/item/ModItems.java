package eyeroh.elementalmastery.item;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.machine.ModMachines;
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

	public static final RegistryObject<Item> NUGGET_OPAL = ITEMS.register("nuggetopal", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> NUGGET_TOPAZ = ITEMS.register("nuggettopaz", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> NUGGET_RUBY = ITEMS.register("nuggetruby", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<Item> NUGGET_SAPPHIRE = ITEMS.register("nuggetsapphire", () -> new Item(new Item.Properties().group(CreativeTabs.tabGemItems)));

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
	
	// Machines
	public static final RegistryObject<Item> COLLECTOR_BAISC_ITEM = ITEMS.register("collectorbasic", () -> new BlockItem(ModMachines.COLLECTOR_BAISC.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> COLLECTOR_SPEED_ITEM = ITEMS.register("collectorspeed", () -> new BlockItem(ModMachines.COLLECTOR_SPEED.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> COLLECTOR_FIRE_ITEM = ITEMS.register("collectorfire", () -> new BlockItem(ModMachines.COLLECTOR_FIRE.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> COLLECTOR_HEAL_ITEM = ITEMS.register("collectorheal", () -> new BlockItem(ModMachines.COLLECTOR_HEAL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> COLLECTOR_STRENGTH_ITEM = ITEMS.register("collectorstrength", () -> new BlockItem(ModMachines.COLLECTOR_STRENGTH.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> GENERATOR_SPEED_ITEM = ITEMS.register("generatorspeed", () -> new BlockItem(ModMachines.GENERATOR_SPEED.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> GENERATOR_FIRE_ITEM = ITEMS.register("generatorfire", () -> new BlockItem(ModMachines.GENERATOR_FIRE.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> GENERATOR_HEAL_ITEM = ITEMS.register("generatorheal", () -> new BlockItem(ModMachines.GENERATOR_HEAL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> GENERATOR_STRENGTH_ITEM = ITEMS.register("generatorstrength", () -> new BlockItem(ModMachines.GENERATOR_STRENGTH.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> CORE_CRAFTER_ITEM = ITEMS.register("corecrafter", () -> new BlockItem(ModMachines.CORE_CRAFTER.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> MINER_ITEM = ITEMS.register("miner", () -> new BlockItem(ModMachines.MINER.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> CAPACITOR_WALL_ITEM = ITEMS.register("capacitorwall", () -> new BlockItem(ModMachines.CAPACITOR_WALL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_CONTROLLER_ITEM = ITEMS.register("capacitorcontroller", () -> new BlockItem(ModMachines.CAPACITOR_CONTROLLER.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_GLASS_ITEM = ITEMS.register("capacitorglass", () -> new BlockItem(ModMachines.CAPACITOR_GLASS.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> CAPACITOR_OPAL_ITEM = ITEMS.register("capacitoropal", () -> new BlockItem(ModMachines.CAPACITOR_OPAL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_TOPAZ_ITEM = ITEMS.register("capacitortopaz", () -> new BlockItem(ModMachines.CAPACITOR_TOPAZ.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_RUBY_ITEM = ITEMS.register("capacitorruby", () -> new BlockItem(ModMachines.CAPACITOR_RUBY.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_SAPPHIRE_ITEM = ITEMS.register("capacitorsapphire", () -> new BlockItem(ModMachines.CAPACITOR_SAPPHIRE.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> CAPACITOR_MULTI_ITEM = ITEMS.register("capacitormulti", () -> new BlockItem(ModMachines.CAPACITOR_MULTI.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> UPGRADE_SPEED_ITEM = ITEMS.register("upgradespeed", () -> new BlockItem(ModMachines.UPGRADE_SPEED.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> UPGRADE_FIRE_ITEM = ITEMS.register("upgradefire", () -> new BlockItem(ModMachines.UPGRADE_FIRE.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> UPGRADE_HEAL_ITEM = ITEMS.register("upgradeheal", () -> new BlockItem(ModMachines.UPGRADE_HEAL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> UPGRADE_STRENGTH_ITEM = ITEMS.register("upgradestrength", () -> new BlockItem(ModMachines.UPGRADE_STRENGTH.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

	public static final RegistryObject<Item> SOLAR_OPAL_ITEM = ITEMS.register("solaropal", () -> new BlockItem(ModMachines.SOLAR_OPAL.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> SOLAR_TOPAZ_ITEM = ITEMS.register("solartopaz", () -> new BlockItem(ModMachines.SOLAR_TOPAZ.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> SOLAR_RUBY_ITEM = ITEMS.register("solarruby", () -> new BlockItem(ModMachines.SOLAR_RUBY.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));
	public static final RegistryObject<Item> SOLAR_SAPPHIRE_ITEM = ITEMS.register("solarsapphire", () -> new BlockItem(ModMachines.SOLAR_SAPPHIRE.get(), new Item.Properties().group(CreativeTabs.tabGemMachines)));

}
