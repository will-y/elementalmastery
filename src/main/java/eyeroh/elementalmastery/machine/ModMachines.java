package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import eyeroh.elementalmastery.machine.generator.GeneratorBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModMachines {
	
	@GameRegistry.ObjectHolder("elementalmastery:collectorbasic")
	public static CollectorBlock collectorBasic;
	
	@GameRegistry.ObjectHolder("elementalmastery:generatoropal")
	public static GeneratorBlock generatorSpeed;
	
	public static void initModels() {
		collectorBasic.initModel();
		
		generatorSpeed.initModel();
	}
}
