package eyeroh.elementalmastery.item;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.entity.CreeperSpawnEgg;
import eyeroh.elementalmastery.entity.ModEntities;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.xml.bind.Element;

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


	public static final RegistryObject<CreeperSpawnEgg> SPEED_CREEPER_SPAWN_EGG = ITEMS.register("speed_creeper_spawn_egg",
			() -> new CreeperSpawnEgg(ModEntities.SPEED_CREEPER, 0xda0bed, 0x860b91, new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<CreeperSpawnEgg> FIRE_CREEPER_SPAWN_EGG = ITEMS.register("fire_creeper_spawn_egg",
			() -> new CreeperSpawnEgg(ModEntities.FIRE_CREEPER, 0xf2860c, 0xa35b0b, new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<CreeperSpawnEgg> STRENGTH_CREEPER_SPAWN_EGG = ITEMS.register("strength_creeper_spawn_egg",
			() -> new CreeperSpawnEgg(ModEntities.STRENGTH_CREEPER, 0x00235b, 0x1d68e0, new Item.Properties().group(CreativeTabs.tabGemItems)));
	public static final RegistryObject<CreeperSpawnEgg> HEAL_CREEPER_SPAWN_EGG = ITEMS.register("heal_creeper_spawn_egg",
			() -> new CreeperSpawnEgg(ModEntities.HEAL_CREEPER, 0xff0000, 0xad1414, new Item.Properties().group(CreativeTabs.tabGemItems)));
}
