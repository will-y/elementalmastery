package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.block.BlockCapacitorGlass;
import eyeroh.elementalmastery.block.GemBlock;
import eyeroh.elementalmastery.block.UpgradeBlock;
import eyeroh.elementalmastery.machine.capacitor.BlockCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import eyeroh.elementalmastery.machine.collector.CollectorFire;
import eyeroh.elementalmastery.machine.collector.CollectorHeal;
import eyeroh.elementalmastery.machine.collector.CollectorSpeed;
import eyeroh.elementalmastery.machine.collector.CollectorStrength;
import eyeroh.elementalmastery.machine.generator.GeneratorBlock;
import eyeroh.elementalmastery.machine.miner.BlockMiner;
import eyeroh.elementalmastery.machine.solar.BlockSolar;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModMachines {
	
	public static final CreativeTabs tabGemMachines = (new CreativeTabs("tabGemMachines") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModMachines.capacitorController);
		}
		
	});
	
	@GameRegistry.ObjectHolder("elementalmastery:collectorbasic")
	public static CollectorBlock collectorBasic;
	
	@GameRegistry.ObjectHolder("elementalmastery:collectorspeed")
	public static CollectorSpeed collectorSpeed;
	@GameRegistry.ObjectHolder("elementalmastery:collectorfire")
	public static CollectorFire collectorFire;
	@GameRegistry.ObjectHolder("elementalmastery:collectorheal")
	public static CollectorHeal collectorHeal;
	@GameRegistry.ObjectHolder("elementalmastery:collectorstrength")
	public static CollectorStrength collectorStrength;
	
	@GameRegistry.ObjectHolder("elementalmastery:generatoropal")
	public static GeneratorBlock generatorOpal;
	@GameRegistry.ObjectHolder("elementalmastery:generatortopaz")
	public static GeneratorBlock generatorTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:generatorruby")
	public static GeneratorBlock generatorRuby;
	@GameRegistry.ObjectHolder("elementalmastery:generatorsapphire")
	public static GeneratorBlock generatorSapphire;
	
	@GameRegistry.ObjectHolder("elementalmastery:corecrafter")
	public static BlockEnergyAcceptor coreCrafter;
	
	@GameRegistry.ObjectHolder("elementalmastery:miner")
	public static BlockMiner miner;

	// Capacitor stuff
	@GameRegistry.ObjectHolder("elementalmastery:capacitorwall")
	public static GemBlock capacitorWall;
	@GameRegistry.ObjectHolder("elementalmastery:capacitorcontroller")
	public static BlockCapacitorController capacitorController;
	@GameRegistry.ObjectHolder("elementalmastery:capacitorglass")
	public static BlockCapacitorGlass capacitorGlass;

	@GameRegistry.ObjectHolder("elementalmastery:capacitoropal")
	public static GemBlock capacitorOpal;
	@GameRegistry.ObjectHolder("elementalmastery:capacitortopaz")
	public static GemBlock capacitorTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:capacitorruby")
	public static GemBlock capacitorRuby;
	@GameRegistry.ObjectHolder("elementalmastery:capacitorsapphire")
	public static GemBlock capacitorSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:capacitormulti")
	public static GemBlock capacitorMulti;

	// Miner Upgrades
	@GameRegistry.ObjectHolder("elementalmastery:upgradespeed")
	public static UpgradeBlock upgradeSpeed;
	@GameRegistry.ObjectHolder("elementalmastery:upgradefire")
	public static UpgradeBlock upgradeFire;
	@GameRegistry.ObjectHolder("elementalmastery:upgradeheal")
	public static UpgradeBlock upgradeHeal;
	@GameRegistry.ObjectHolder("elementalmastery:upgradestrength")
	public static UpgradeBlock upgradeStrength;

	// Solars
	@GameRegistry.ObjectHolder("elementalmastery:solaropal")
	public static BlockSolar solarOpal;
	@GameRegistry.ObjectHolder("elementalmastery:solartopaz")
	public static BlockSolar solarTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:solarruby")
	public static BlockSolar solarRuby;
	@GameRegistry.ObjectHolder("elementalmastery:solarsapphire")
	public static BlockSolar solarSapphire;
	
	public static void initModels() {
		collectorBasic.initModel();
		
		generatorOpal.initModel();
		generatorTopaz.initModel();
		generatorRuby.initModel();
		generatorSapphire.initModel();
		
		collectorSpeed.initModel();
		collectorFire.initModel();
		collectorHeal.initModel();
		collectorStrength.initModel();
		
		coreCrafter.initModel();
		
		miner.initModel();

		capacitorWall.initModel();
		capacitorController.initModel();
		capacitorGlass.initModel();

		capacitorOpal.initModel();
		capacitorTopaz.initModel();
		capacitorRuby.initModel();
		capacitorSapphire.initModel();
		capacitorMulti.initModel();

		upgradeSpeed.initModel();
		upgradeFire.initModel();
		upgradeHeal.initModel();
		upgradeStrength.initModel();

		solarOpal.initModel();
		solarTopaz.initModel();
		solarRuby.initModel();
		solarSapphire.initModel();
	}
}
