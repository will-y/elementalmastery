package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import eyeroh.elementalmastery.machine.collector.CollectorFire;
import eyeroh.elementalmastery.machine.collector.CollectorHeal;
import eyeroh.elementalmastery.machine.collector.CollectorSpeed;
import eyeroh.elementalmastery.machine.collector.CollectorStrength;
import eyeroh.elementalmastery.machine.generator.GeneratorBlock;
import eyeroh.elementalmastery.machine.miner.BlockMiner;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModMachines {
	
	public static final CreativeTabs tabGemMachines = (new CreativeTabs("tabGemMachines") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModMachines.collectorSpeed);
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
	}
}
