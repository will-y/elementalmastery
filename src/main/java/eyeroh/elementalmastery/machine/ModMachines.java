package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.BlockCapacitorGlass;
import eyeroh.elementalmastery.block.GemBlock;
import eyeroh.elementalmastery.block.UpgradeBlock;
import eyeroh.elementalmastery.machine.capacitor.BlockCapacitorController;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import eyeroh.elementalmastery.machine.collector.CollectorFire;
import eyeroh.elementalmastery.machine.collector.CollectorHeal;
import eyeroh.elementalmastery.machine.collector.CollectorSpeed;
import eyeroh.elementalmastery.machine.collector.CollectorStrength;
import eyeroh.elementalmastery.machine.generator.GeneratorBlock;
import eyeroh.elementalmastery.machine.miner.BlockMiner;
import eyeroh.elementalmastery.machine.solar.BlockSolar;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMachines {
	
	public static final DeferredRegister<Block> MACHINES = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalMastery.MODID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalMastery.MODID);
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ElementalMastery.MODID);
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ElementalMastery.MODID);

	public static final RegistryObject<Block> COLLECTOR_BAISC = MACHINES.register("collectorbasic", () -> new CollectorBlock(4));

	public static final RegistryObject<Block> COLLECTOR_SPEED = MACHINES.register("collectorspeed", CollectorSpeed::new);
	public static final RegistryObject<Block> COLLECTOR_FIRE = MACHINES.register("collectorfire", CollectorFire::new);
	public static final RegistryObject<Block> COLLECTOR_HEAL = MACHINES.register("collectorheal", CollectorHeal::new);
	public static final RegistryObject<Block> COLLECTOR_STRENGTH = MACHINES.register("collectorstrength", CollectorStrength::new);

	public static final RegistryObject<Block> GENERATOR_SPEED = MACHINES.register("generatorspeed", () -> new GeneratorBlock("speed", 0));
	public static final RegistryObject<Block> GENERATOR_FIRE = MACHINES.register("generatorfire", () -> new GeneratorBlock("fire", 1));
	public static final RegistryObject<Block> GENERATOR_HEAL = MACHINES.register("generatorheal", () -> new GeneratorBlock("heal", 2));
	public static final RegistryObject<Block> GENERATOR_STRENGTH = MACHINES.register("generatorstrength", () -> new GeneratorBlock("strength", 3));

	public static final RegistryObject<Block> CORE_CRAFTER = MACHINES.register("corecrafter", () -> new BlockEnergyAcceptor(0, 0));

	public static final RegistryObject<Block> MINER = MACHINES.register("miner", BlockMiner::new);

	public static final RegistryObject<Block> CAPACITOR_WALL = MACHINES.register("capacitorwall", GemBlock::new);
	public static final RegistryObject<Block> CAPACITOR_CONTROLLER = MACHINES.register("capacitorcontroller", BlockCapacitorController::new);
	public static final RegistryObject<Block> CAPACITOR_GLASS = MACHINES.register("capacitorglass", BlockCapacitorGlass::new);

	public static final RegistryObject<TileEntityType<TileEntityCapacitorController>> CAPACITOR_CONTROLLER_TILE = TILES.register("capacitorcontroller", () -> TileEntityType.Builder.create(TileEntityCapacitorController::new, CAPACITOR_CONTROLLER.get()).build(null));

	public static final RegistryObject<Block> CAPACITOR_OPAL = MACHINES.register("capacitoropal", GemBlock::new);
	public static final RegistryObject<Block> CAPACITOR_TOPAZ = MACHINES.register("capacitortopaz", GemBlock::new);
	public static final RegistryObject<Block> CAPACITOR_RUBY = MACHINES.register("capacitorruby", GemBlock::new);
	public static final RegistryObject<Block> CAPACITOR_SAPPHIRE = MACHINES.register("capacitorsapphire", GemBlock::new);
	public static final RegistryObject<Block> CAPACITOR_MULTI = MACHINES.register("capacitormulti", GemBlock::new);

	public static final RegistryObject<Block> UPGRADE_SPEED = MACHINES.register("upgradespeed", () -> new UpgradeBlock(0));
	public static final RegistryObject<Block> UPGRADE_FIRE = MACHINES.register("upgradefire", () -> new UpgradeBlock(1));
	public static final RegistryObject<Block> UPGRADE_HEAL = MACHINES.register("upgradeheal", () -> new UpgradeBlock(2));
	public static final RegistryObject<Block> UPGRADE_STRENGTH = MACHINES.register("upgradestrength", () -> new UpgradeBlock(3));

	public static final RegistryObject<Block> SOLAR_OPAL = MACHINES.register("solaropal", () -> new BlockSolar("opal", 0));
	public static final RegistryObject<Block> SOLAR_TOPAZ = MACHINES.register("solartopaz", () -> new BlockSolar("topaz", 1));
	public static final RegistryObject<Block> SOLAR_RUBY = MACHINES.register("solarruby", () -> new BlockSolar("ruby", 2));
	public static final RegistryObject<Block> SOLAR_SAPPHIRE = MACHINES.register("solarsapphire", () -> new BlockSolar("sapphire", 3));
}
