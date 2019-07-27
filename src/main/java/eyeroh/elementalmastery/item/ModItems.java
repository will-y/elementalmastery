package eyeroh.elementalmastery.item;

import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
	
	public static final CreativeTabs tabGemItems = (new CreativeTabs("tabGemItems") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.gemOpal);
		}
		
	});
	
	public static final CreativeTabs tabGemTools = (new CreativeTabs("tabGemTools") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModTools.pickaxeOpal);
		}
		
	});
	
	//Items
	//Gems
	@GameRegistry.ObjectHolder("elementalmastery:gemopal")
	public static GemItem gemOpal;
	@GameRegistry.ObjectHolder("elementalmastery:gemtopaz")
	public static GemItem gemTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:gemruby")
	public static GemItem gemRuby;
	@GameRegistry.ObjectHolder("elementalmastery:gemsapphire")
	public static GemItem gemSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:gemmulti")
	public static GemItem gemMulti;
	
	//Misc
	@GameRegistry.ObjectHolder("elementalmastery:toolbinder")
	public static GemItem toolBinder;
	
	@GameRegistry.ObjectHolder("elementalmastery:energycoreopal")
	public static GemItem energycoreOpal;
	@GameRegistry.ObjectHolder("elementalmastery:energycoretopaz")
	public static GemItem energycoreTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:energycoreruby")
	public static GemItem energycoreRuby;
	@GameRegistry.ObjectHolder("elementalmastery:energycoresapphire")
	public static GemItem energycoreSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:energycoremulti")
	public static GemItem energycoreMulti;
	
	@GameRegistry.ObjectHolder("elementalmastery:energycoreopal_active")
	public static GemItem energycoreOpalActive;
	@GameRegistry.ObjectHolder("elementalmastery:energycoretopaz_active")
	public static GemItem energycoreTopazActive;
	@GameRegistry.ObjectHolder("elementalmastery:energycoreruby_active")
	public static GemItem energycoreRubyActive;
	@GameRegistry.ObjectHolder("elementalmastery:energycoresapphire_active")
	public static GemItem energycoreSapphireActive;
	@GameRegistry.ObjectHolder("elementalmastery:energycoremulti_active")
	public static GemItem energycoreMultiActive;
	
	@GameRegistry.ObjectHolder("elementalmastery:energycorefragment")
	public static GemItem energycoreFragment;
	
	@GameRegistry.ObjectHolder("elementalmastery:dustopal")
	public static GemItem dustOpal;
	@GameRegistry.ObjectHolder("elementalmastery:dusttopaz")
	public static GemItem dustTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:dustruby")
	public static GemItem dustRuby;
	@GameRegistry.ObjectHolder("elementalmastery:dustsapphire")
	public static GemItem dustSapphire;
	
	@GameRegistry.ObjectHolder("elementalmastery:dustopalsmall")
	public static GemItem dustOpalSmall;
	@GameRegistry.ObjectHolder("elementalmastery:dusttopazsmall")
	public static GemItem dustTopazSmall;
	@GameRegistry.ObjectHolder("elementalmastery:dustrubysmall")
	public static GemItem dustRubySmall;
	@GameRegistry.ObjectHolder("elementalmastery:dustsapphiresmall")
	public static GemItem dustSapphireSmall;
	
	@GameRegistry.ObjectHolder("elementalmastery:nuggetopal")
	public static GemItem nuggetOpal;
	@GameRegistry.ObjectHolder("elementalmastery:nuggettopaz")
	public static GemItem nuggetTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:nuggetruby")
	public static GemItem nuggetRuby;
	@GameRegistry.ObjectHolder("elementalmastery:nuggetsapphire")
	public static GemItem nuggetSapphire;
	
	@GameRegistry.ObjectHolder("elementalmastery:smallheart")
	public static GemItem smallHeart;

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		gemOpal.initModel();
		gemTopaz.initModel();
		gemRuby.initModel();
		gemSapphire.initModel();
		gemMulti.initModel();
		
		toolBinder.initModel();
		
		energycoreOpal.initModel();
		energycoreTopaz.initModel();
		energycoreRuby.initModel();
		energycoreSapphire.initModel();
		energycoreMulti.initModel();
		
		energycoreOpalActive.initModel();
		energycoreTopazActive.initModel();
		energycoreRubyActive.initModel();
		energycoreSapphireActive.initModel();
		energycoreMultiActive.initModel();
		
		energycoreFragment.initModel();
		
		dustOpal.initModel();
		dustTopaz.initModel();
		dustRuby.initModel();
		dustSapphire.initModel();
		
		dustOpalSmall.initModel();
		dustTopazSmall.initModel();
		dustRubySmall.initModel();
		dustSapphireSmall.initModel();
		
		nuggetOpal.initModel();
		nuggetTopaz.initModel();
		nuggetRuby.initModel();
		nuggetSapphire.initModel();
		
		smallHeart.initModel();
	}
}
