package eyeroh.elementalmastery.proxy;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.ModRecipes;
import eyeroh.elementalmastery.block.BlockCapacitorGlass;
import eyeroh.elementalmastery.block.GemBlock;
import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.block.OreBlock;
import eyeroh.elementalmastery.item.GemItem;
import eyeroh.elementalmastery.item.GemShinyItem;
import eyeroh.elementalmastery.item.armor.GemArmor;
import eyeroh.elementalmastery.item.armor.ModArmor;
import eyeroh.elementalmastery.item.armor.SpecialArmor;
import eyeroh.elementalmastery.item.tool.FireAxe;
import eyeroh.elementalmastery.item.tool.FirePickaxe;
import eyeroh.elementalmastery.item.tool.FireShovel;
import eyeroh.elementalmastery.item.tool.FireSword;
import eyeroh.elementalmastery.item.tool.GemAxe;
import eyeroh.elementalmastery.item.tool.GemHoe;
import eyeroh.elementalmastery.item.tool.GemPickaxe;
import eyeroh.elementalmastery.item.tool.GemShovel;
import eyeroh.elementalmastery.item.tool.GemSword;
import eyeroh.elementalmastery.item.tool.HealAxe;
import eyeroh.elementalmastery.item.tool.HealSword;
import eyeroh.elementalmastery.item.tool.ItemFarmer;
import eyeroh.elementalmastery.item.tool.ItemLinker;
import eyeroh.elementalmastery.item.tool.ItemMiner;
import eyeroh.elementalmastery.item.tool.ItemMultiTool;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.item.tool.SpeedSword;
import eyeroh.elementalmastery.item.tool.StrengthAxe;
import eyeroh.elementalmastery.item.tool.StrengthPickaxe;
import eyeroh.elementalmastery.item.tool.StrengthShovel;
import eyeroh.elementalmastery.item.tool.StrengthSword;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.capacitor.BlockCapacitorController;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import eyeroh.elementalmastery.machine.generator.GeneratorBlock;
import eyeroh.elementalmastery.machine.generator.GeneratorTileEntity;
import eyeroh.elementalmastery.mob.ModEntities;
import eyeroh.elementalmastery.world.OreGen;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    	ModEntities.init();
    }

    public void init(FMLInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new OreGen(), 0);
    	ModRecipes.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(ElementalMastery.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	//Gem Blocks
    	event.getRegistry().register(new GemBlock("blockopal"));
    	event.getRegistry().register(new GemBlock("blocktopaz"));
    	event.getRegistry().register(new GemBlock("blockruby"));
    	event.getRegistry().register(new GemBlock("blocksapphire"));
    	
    	//Gem Ores
    	event.getRegistry().register(new OreBlock("oreopal"));
    	event.getRegistry().register(new OreBlock("oretopaz"));
    	event.getRegistry().register(new OreBlock("oreruby"));
    	event.getRegistry().register(new OreBlock("oresapphire"));
    	
    	//Capcitor Blocks
    	event.getRegistry().register(new GemBlock("capacitorwall"));
    	event.getRegistry().register(new BlockCapacitorController());
    	GameRegistry.registerTileEntity(TileEntityCapacitorController.class, ElementalMastery.MODID + "_capacitorcontroller");
    	event.getRegistry().register(new BlockCapacitorGlass());
    	
    	event.getRegistry().register(new GemBlock("capacitoropal"));
    	event.getRegistry().register(new GemBlock("capacitortopaz"));
    	event.getRegistry().register(new GemBlock("capacitorruby"));
    	event.getRegistry().register(new GemBlock("capacitorsapphire"));
    	event.getRegistry().register(new GemBlock("capacitormulti"));
    	
    	//Machines
    	event.getRegistry().register(new CollectorBlock());
    	GameRegistry.registerTileEntity(CollectorBasicTileEntity.class, ElementalMastery.MODID + "_collector");
    	
    	event.getRegistry().register(new GeneratorBlock("opal", 0));
    	GameRegistry.registerTileEntity(GeneratorTileEntity.class, ElementalMastery.MODID + "_generatorbasic");
    	event.getRegistry().register(new GeneratorBlock("topaz", 1));
    	event.getRegistry().register(new GeneratorBlock("ruby", 2));
    	event.getRegistry().register(new GeneratorBlock("sapphire", 3));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	//Item Blocks
    	//Gem Blocks
    	event.getRegistry().register(new ItemBlock(ModBlocks.blockopal).setRegistryName(ModBlocks.blockopal.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.blocktopaz).setRegistryName(ModBlocks.blocktopaz.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.blockruby).setRegistryName(ModBlocks.blockruby.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.blocksapphire).setRegistryName(ModBlocks.blocksapphire.getRegistryName()));
    	
    	//Gem Ores
    	event.getRegistry().register(new ItemBlock(ModBlocks.oreopal).setRegistryName(ModBlocks.oreopal.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.oretopaz).setRegistryName(ModBlocks.oretopaz.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.oreruby).setRegistryName(ModBlocks.oreruby.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.oresapphire).setRegistryName(ModBlocks.oresapphire.getRegistryName()));
    	
    	//capacitor blocks
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorWall).setRegistryName(ModBlocks.capacitorWall.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorController).setRegistryName(ModBlocks.capacitorController.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorGlass).setRegistryName(ModBlocks.capacitorGlass.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorOpal).setRegistryName(ModBlocks.capacitorOpal.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorTopaz).setRegistryName(ModBlocks.capacitorTopaz.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorRuby).setRegistryName(ModBlocks.capacitorRuby.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorSapphire).setRegistryName(ModBlocks.capacitorSapphire.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModBlocks.capacitorMulti).setRegistryName(ModBlocks.capacitorMulti.getRegistryName()));
    	
    	//Machines
    	event.getRegistry().register(new ItemBlock(ModMachines.collectorBasic).setRegistryName(ModMachines.collectorBasic.getRegistryName()));
    	
    	event.getRegistry().register(new ItemBlock(ModMachines.generatorOpal).setRegistryName(ModMachines.generatorOpal.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModMachines.generatorTopaz).setRegistryName(ModMachines.generatorTopaz.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModMachines.generatorRuby).setRegistryName(ModMachines.generatorRuby.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(ModMachines.generatorSapphire).setRegistryName(ModMachines.generatorSapphire.getRegistryName()));
    	
    	//Items
    	event.getRegistry().register(new GemItem("gemopal"));
    	event.getRegistry().register(new GemItem("gemtopaz"));
    	event.getRegistry().register(new GemItem("gemruby"));
    	event.getRegistry().register(new GemItem("gemsapphire"));
    	event.getRegistry().register(new GemItem("gemmulti"));
    	
    	//Tools
    	event.getRegistry().register(new GemPickaxe("pickaxeopal"));
    	event.getRegistry().register(new GemPickaxe("pickaxetopaz"));
    	event.getRegistry().register(new GemPickaxe("pickaxeruby"));
    	event.getRegistry().register(new GemPickaxe("pickaxesapphire"));
    	
    	event.getRegistry().register(new GemAxe("axeopal"));
    	event.getRegistry().register(new GemAxe("axetopaz"));
    	event.getRegistry().register(new GemAxe("axeruby"));
    	event.getRegistry().register(new GemAxe("axesapphire"));
    	
    	event.getRegistry().register(new GemSword("swordopal"));
    	event.getRegistry().register(new GemSword("swordtopaz"));
    	event.getRegistry().register(new GemSword("swordruby"));
    	event.getRegistry().register(new GemSword("swordsapphire"));
    	
    	event.getRegistry().register(new GemHoe("hoeopal"));
    	event.getRegistry().register(new GemHoe("hoetopaz"));
    	event.getRegistry().register(new GemHoe("hoeruby"));
    	event.getRegistry().register(new GemHoe("hoesapphire"));
    	
    	event.getRegistry().register(new GemShovel("shovelopal"));
    	event.getRegistry().register(new GemShovel("shoveltopaz"));
    	event.getRegistry().register(new GemShovel("shovelruby"));
    	event.getRegistry().register(new GemShovel("shovelsapphire"));
    	
    	event.getRegistry().register(new ItemMiner(ModTools.TOOLMATERIALGEM, "mineropal"));
    	event.getRegistry().register(new ItemMiner(ModTools.TOOLMATERIALGEM, "minertopaz"));
    	event.getRegistry().register(new ItemMiner(ModTools.TOOLMATERIALGEM, "minerruby"));
    	event.getRegistry().register(new ItemMiner(ModTools.TOOLMATERIALGEM, "minersapphire"));
    	event.getRegistry().register(new ItemMiner(ToolMaterial.WOOD, "minerwood"));
    	event.getRegistry().register(new ItemMiner(ToolMaterial.STONE, "minerstone"));
    	event.getRegistry().register(new ItemMiner(ToolMaterial.IRON, "mineriron"));
    	event.getRegistry().register(new ItemMiner(ToolMaterial.GOLD, "minergold"));
    	event.getRegistry().register(new ItemMiner(ToolMaterial.DIAMOND, "minerdiamond"));
    	
    	event.getRegistry().register(new ItemFarmer(ModTools.TOOLMATERIALGEM, "farmeropal", 7.0f, -3.0f));
    	event.getRegistry().register(new ItemFarmer(ModTools.TOOLMATERIALGEM, "farmertopaz", 7.0f, -3.0f));
    	event.getRegistry().register(new ItemFarmer(ModTools.TOOLMATERIALGEM, "farmerruby", 7.0f, -3.0f));
    	event.getRegistry().register(new ItemFarmer(ModTools.TOOLMATERIALGEM, "farmersapphire", 7.0f, -3.0f));
    	event.getRegistry().register(new ItemFarmer(ToolMaterial.WOOD, "farmerwood", 6.0f, -3.2f));
    	event.getRegistry().register(new ItemFarmer(ToolMaterial.STONE, "farmerstone", 8.0f, -3.2f));
    	event.getRegistry().register(new ItemFarmer(ToolMaterial.IRON, "farmeriron", 8.0f, -3.1f));
    	event.getRegistry().register(new ItemFarmer(ToolMaterial.GOLD, "farmergold", 6.0f, -3.0f));
    	event.getRegistry().register(new ItemFarmer(ToolMaterial.DIAMOND, "farmerdiamond", 6.0f, -3.0f));
    	
    	event.getRegistry().register(new ItemMultiTool(ModTools.TOOLMATERIALGEM, "multiopal", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ModTools.TOOLMATERIALGEM, "multitopaz", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ModTools.TOOLMATERIALGEM, "multiruby", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ModTools.TOOLMATERIALGEM, "multisapphire", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ToolMaterial.WOOD, "multiwood", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ToolMaterial.STONE, "multistone", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ToolMaterial.IRON, "multiiron", -1.6f));
    	event.getRegistry().register(new ItemMultiTool(ToolMaterial.GOLD, "multigold", 1.6f));
    	event.getRegistry().register(new ItemMultiTool(ToolMaterial.DIAMOND, "multidiamond", -1.6f));
    	
    	event.getRegistry().register(new StrengthPickaxe("strengthpickaxe"));
    	event.getRegistry().register(new StrengthShovel("strengthshovel"));
    	event.getRegistry().register(new StrengthAxe("strengthaxe"));
    	event.getRegistry().register(new StrengthSword());
    	
    	event.getRegistry().register(new SpeedSword());
    	
    	event.getRegistry().register(new FireSword());
    	event.getRegistry().register(new FirePickaxe());
    	event.getRegistry().register(new FireAxe());
    	event.getRegistry().register(new FireShovel());
    	
    	event.getRegistry().register(new HealSword());
    	event.getRegistry().register(new HealAxe());
    	
    	//armor
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALOPAL, 0, EntityEquipmentSlot.HEAD, "helmetopal"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALOPAL, 0, EntityEquipmentSlot.CHEST, "chestplateopal"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALOPAL, 0, EntityEquipmentSlot.LEGS, "leggingsopal"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALOPAL, 0, EntityEquipmentSlot.FEET, "bootsopal"));
    	
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALTOPAZ, 0, EntityEquipmentSlot.HEAD, "helmettopaz"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALTOPAZ, 0, EntityEquipmentSlot.CHEST, "chestplatetopaz"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALTOPAZ, 0, EntityEquipmentSlot.LEGS, "leggingstopaz"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALTOPAZ, 0, EntityEquipmentSlot.FEET, "bootstopaz"));
    	
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALRUBY, 0, EntityEquipmentSlot.HEAD, "helmetruby"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALRUBY, 0, EntityEquipmentSlot.CHEST, "chestplateruby"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALRUBY, 0, EntityEquipmentSlot.LEGS, "leggingsruby"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALRUBY, 0, EntityEquipmentSlot.FEET, "bootsruby"));
    	
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALSAPPHIRE, 0, EntityEquipmentSlot.HEAD, "helmetsapphire"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALSAPPHIRE, 0, EntityEquipmentSlot.CHEST, "chestplatesapphire"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALSAPPHIRE, 0, EntityEquipmentSlot.LEGS, "leggingssapphire"));
    	event.getRegistry().register(new GemArmor(ModArmor.ARMORMATERIALSAPPHIRE, 0, EntityEquipmentSlot.FEET, "bootssapphire"));
    	
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSPEED, 0, EntityEquipmentSlot.HEAD, "helmetspeed"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSPEED, 0, EntityEquipmentSlot.CHEST, "chestplatespeed"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSPEED, 0, EntityEquipmentSlot.LEGS, "leggingsspeed"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSPEED, 0, EntityEquipmentSlot.FEET, "bootsspeed"));
    	
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALFIRE, 0, EntityEquipmentSlot.HEAD, "helmetfire"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALFIRE, 0, EntityEquipmentSlot.CHEST, "chestplatefire"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALFIRE, 0, EntityEquipmentSlot.LEGS, "leggingsfire"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALFIRE, 0, EntityEquipmentSlot.FEET, "bootsfire"));
    	
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALHEAL, 0, EntityEquipmentSlot.HEAD, "helmetheal"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALHEAL, 0, EntityEquipmentSlot.CHEST, "chestplateheal"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALHEAL, 0, EntityEquipmentSlot.LEGS, "leggingsheal"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALHEAL, 0, EntityEquipmentSlot.FEET, "bootsheal"));
    	
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSTRENGTH, 0, EntityEquipmentSlot.HEAD, "helmetstrength"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSTRENGTH, 0, EntityEquipmentSlot.CHEST, "chestplatestrength"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSTRENGTH, 0, EntityEquipmentSlot.LEGS, "leggingsstrength"));
    	event.getRegistry().register(new SpecialArmor(ModArmor.ARMORMATERIALSTRENGTH, 0, EntityEquipmentSlot.FEET, "bootsstrength"));
    	
    	//Misc
    	event.getRegistry().register(new GemItem("toolbinder"));
    	
    	event.getRegistry().register(new GemItem("energycoreopal"));
    	event.getRegistry().register(new GemItem("energycoretopaz"));
    	event.getRegistry().register(new GemItem("energycoreruby"));
    	event.getRegistry().register(new GemItem("energycoresapphire"));
    	event.getRegistry().register(new GemItem("energycoremulti"));
    	
    	event.getRegistry().register(new GemShinyItem("energycoreopal_active"));
    	event.getRegistry().register(new GemShinyItem("energycoretopaz_active"));
    	event.getRegistry().register(new GemShinyItem("energycoreruby_active"));
    	event.getRegistry().register(new GemShinyItem("energycoresapphire_active"));
    	event.getRegistry().register(new GemShinyItem("energycoremulti_active"));
    	
    	event.getRegistry().register(new GemItem("energycorefragment"));
    	
    	event.getRegistry().register(new GemItem("dustopal"));
    	event.getRegistry().register(new GemItem("dusttopaz"));
    	event.getRegistry().register(new GemItem("dustruby"));
    	event.getRegistry().register(new GemItem("dustsapphire"));
    	
    	event.getRegistry().register(new GemItem("dustopalsmall"));
    	event.getRegistry().register(new GemItem("dusttopazsmall"));
    	event.getRegistry().register(new GemItem("dustrubysmall"));
    	event.getRegistry().register(new GemItem("dustsapphiresmall"));
    	
    	event.getRegistry().register(new GemItem("nuggetopal"));
    	event.getRegistry().register(new GemItem("nuggettopaz"));
    	event.getRegistry().register(new GemItem("nuggetruby"));
    	event.getRegistry().register(new GemItem("nuggetsapphire"));
    	
    	event.getRegistry().register(new GemItem("smallheart"));
    	
    	event.getRegistry().register(new ItemLinker());
    }
}