package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModMachines {
	
	@GameRegistry.ObjectHolder("elementalmastery:collectorbasic")
	public static CollectorBlock collectorBasic;
	
	public static void initModels() {
		collectorBasic.initModel();
	}
}
