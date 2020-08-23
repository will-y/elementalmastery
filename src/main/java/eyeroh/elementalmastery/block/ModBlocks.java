package eyeroh.elementalmastery.block;

import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.capacitor.BlockCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static final CreativeTabs tabGemBlocks = (new CreativeTabs("tabGemBlocks") {

		@Override
		public ItemStack getTabIconItem() {
			// TODO Auto-generated method stub
			return new ItemStack(ModMachines.collectorSpeed);
		}
		
	});
	
	//Gem Blocks
	@GameRegistry.ObjectHolder("elementalmastery:blockopal")
	public static GemBlock blockopal;
	@GameRegistry.ObjectHolder("elementalmastery:blocktopaz")
	public static GemBlock blocktopaz;
	@GameRegistry.ObjectHolder("elementalmastery:blockruby")
	public static GemBlock blockruby;
	@GameRegistry.ObjectHolder("elementalmastery:blocksapphire")
	public static GemBlock blocksapphire;
	
	//Gem Ores
	@GameRegistry.ObjectHolder("elementalmastery:oreopal")
	public static OreBlock oreopal;
	@GameRegistry.ObjectHolder("elementalmastery:oretopaz")
	public static OreBlock oretopaz;
	@GameRegistry.ObjectHolder("elementalmastery:oreruby")
	public static OreBlock oreruby;
	@GameRegistry.ObjectHolder("elementalmastery:oresapphire")
	public static OreBlock oresapphire;

	public static void initModels() {
		//Gem Blocks
		blockopal.initModel();
		blocktopaz.initModel();
		blockruby.initModel();
		blocksapphire.initModel();
		
		//Gem Ores
		oreopal.initModel();
		oretopaz.initModel();
		oreruby.initModel();
		oresapphire.initModel();
		
	}
}