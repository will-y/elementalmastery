package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.item.GemItem;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTools {
	
	public static ToolMaterial TOOLMATERIALGEM = EnumHelper.addToolMaterial("TOOLMATERIALGEM", 2, 550, 7.0f, 2.5f, 10);
	
	public static ToolMaterial TOOLMATERIALSPEED = EnumHelper.addToolMaterial("TOOLMATERIALSPEED", 2, 750, 9.0f,  2.5f, 10);
	public static ToolMaterial TOOLMATERIALFIRE = EnumHelper.addToolMaterial("TOOLMATERIALFIRE", 2, 1000, 7.0f,  3.0f, 10);
	public static ToolMaterial TOOLMATERIALHEAL = EnumHelper.addToolMaterial("TOOLMATERIALHEAL", 2, 1000, 7.0f,  3.0f, 10);
	public static ToolMaterial TOOLMATERIALSTRENGTH = EnumHelper.addToolMaterial("TOOLMATERIALSTRENGTH", 2, 1250, 6.0f,  3.5f, 10);
	
	//picks
	@GameRegistry.ObjectHolder("elementalmastery:pickaxeopal")
	public static GemPickaxe pickaxeOpal;
	@GameRegistry.ObjectHolder("elementalmastery:pickaxetopaz")
	public static GemPickaxe pickaxeTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:pickaxeruby")
	public static GemPickaxe pickaxeRuby;
	@GameRegistry.ObjectHolder("elementalmastery:pickaxesapphire")
	public static GemPickaxe pickaxeSapphire;
	
	//axes
	@GameRegistry.ObjectHolder("elementalmastery:axeopal")
	public static GemAxe axeOpal;
	@GameRegistry.ObjectHolder("elementalmastery:axetopaz")
	public static GemAxe axeTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:axeruby")
	public static GemAxe axeRuby;
	@GameRegistry.ObjectHolder("elementalmastery:axesapphire")
	public static GemAxe axeSapphire;
	
	//swords
	@GameRegistry.ObjectHolder("elementalmastery:swordopal")
	public static GemSword swordOpal;
	@GameRegistry.ObjectHolder("elementalmastery:swordtopaz")
	public static GemSword swordTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:swordruby")
	public static GemSword swordRuby;
	@GameRegistry.ObjectHolder("elementalmastery:swordsapphire")
	public static GemSword swordSapphire;
	
	//hoes
	@GameRegistry.ObjectHolder("elementalmastery:hoeopal")
	public static GemHoe hoeOpal;
	@GameRegistry.ObjectHolder("elementalmastery:hoetopaz")
	public static GemHoe hoeTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:hoeruby")
	public static GemHoe hoeRuby;
	@GameRegistry.ObjectHolder("elementalmastery:hoesapphire")
	public static GemHoe hoeSapphire;
	
	//shovels
	@GameRegistry.ObjectHolder("elementalmastery:shovelopal")
	public static GemShovel shovelOpal;
	@GameRegistry.ObjectHolder("elementalmastery:shoveltopaz")
	public static GemShovel shovelTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:shovelruby")
	public static GemShovel shovelRuby;
	@GameRegistry.ObjectHolder("elementalmastery:shovelsapphire")
	public static GemShovel shovelSapphire;
	
	//miners
	@GameRegistry.ObjectHolder("elementalmastery:mineropal")
	public static ItemMiner minerOpal;
	@GameRegistry.ObjectHolder("elementalmastery:minertopaz")
	public static ItemMiner minerTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:minerruby")
	public static ItemMiner minerRuby;
	@GameRegistry.ObjectHolder("elementalmastery:minersapphire")
	public static ItemMiner minerSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:minerwood")
	public static ItemMiner minerWood;
	@GameRegistry.ObjectHolder("elementalmastery:minerstone")
	public static ItemMiner minerStone;
	@GameRegistry.ObjectHolder("elementalmastery:mineriron")
	public static ItemMiner minerIron;
	@GameRegistry.ObjectHolder("elementalmastery:minergold")
	public static ItemMiner minerGold;
	@GameRegistry.ObjectHolder("elementalmastery:minerdiamond")
	public static ItemMiner minerDiamond;
	
	//farmers
	@GameRegistry.ObjectHolder("elementalmastery:farmeropal")
	public static ItemFarmer farmerOpal;
	@GameRegistry.ObjectHolder("elementalmastery:farmertopaz")
	public static ItemFarmer farmerTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:farmerruby")
	public static ItemFarmer farmerRuby;
	@GameRegistry.ObjectHolder("elementalmastery:farmersapphire")
	public static ItemFarmer farmerSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:farmerwood")
	public static ItemFarmer farmerWood;
	@GameRegistry.ObjectHolder("elementalmastery:farmerstone")
	public static ItemFarmer farmerStone;
	@GameRegistry.ObjectHolder("elementalmastery:farmeriron")
	public static ItemFarmer farmerIron;
	@GameRegistry.ObjectHolder("elementalmastery:farmergold")
	public static ItemFarmer farmerGold;
	@GameRegistry.ObjectHolder("elementalmastery:farmerdiamond")
	public static ItemFarmer farmerDiamond;
	
	//multi tools
	@GameRegistry.ObjectHolder("elementalmastery:multiopal")
	public static ItemMultiTool multiOpal;
	@GameRegistry.ObjectHolder("elementalmastery:multitopaz")
	public static ItemMultiTool multiTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:multiruby")
	public static ItemMultiTool multiRuby;
	@GameRegistry.ObjectHolder("elementalmastery:multisapphire")
	public static ItemMultiTool multiSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:multiwood")
	public static ItemMultiTool multiWood;
	@GameRegistry.ObjectHolder("elementalmastery:multistone")
	public static ItemMultiTool multiStone;
	@GameRegistry.ObjectHolder("elementalmastery:multiiron")
	public static ItemMultiTool multiIron;
	@GameRegistry.ObjectHolder("elementalmastery:multigold")
	public static ItemMultiTool multiGold;
	@GameRegistry.ObjectHolder("elementalmastery:multidiamond")
	public static ItemMultiTool multiDiamond;
	
	//special
	@GameRegistry.ObjectHolder("elementalmastery:strengthpickaxe")
	public static StrengthPickaxe strengthPickaxe;
	@GameRegistry.ObjectHolder("elementalmastery:strengthshovel")
	public static StrengthShovel strengthShovel;
	@GameRegistry.ObjectHolder("elementalmastery:strengthaxe")
	public static StrengthAxe strengthAxe;
	@GameRegistry.ObjectHolder("elementalmastery:strengthsword")
	public static StrengthSword strengthSword;
	
	@GameRegistry.ObjectHolder("elementalmastery:speedsword")
	public static SpeedSword speedSword;
	
	@GameRegistry.ObjectHolder("elementalmastery:firesword")
	public static FireSword fireSword;
	@GameRegistry.ObjectHolder("elementalmastery:firepickaxe")
	public static FirePickaxe firePickaxe;
	@GameRegistry.ObjectHolder("elementalmastery:fireaxe")
	public static FireAxe fireAxe;
	@GameRegistry.ObjectHolder("elementalmastery:fireshovel")
	public static FireShovel fireShovel;
	
	@GameRegistry.ObjectHolder("elementalmastery:healsword")
	public static HealSword healSword;
	@GameRegistry.ObjectHolder("elementalmastery:healaxe")
	public static HealAxe healAxe;
	
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		pickaxeOpal.initModel();
		pickaxeTopaz.initModel();
		pickaxeRuby.initModel();
		pickaxeSapphire.initModel();
		
		axeOpal.initModel();
		axeTopaz.initModel();
		axeRuby.initModel();
		axeSapphire.initModel();
		
		swordOpal.initModel();
		swordTopaz.initModel();
		swordRuby.initModel();
		swordSapphire.initModel();
		
		hoeOpal.initModel();
		hoeTopaz.initModel();
		hoeRuby.initModel();
		hoeSapphire.initModel();
		
		shovelOpal.initModel();
		shovelTopaz.initModel();
		shovelRuby.initModel();
		shovelSapphire.initModel();
		
		minerOpal.initModel();
		minerTopaz.initModel();
		minerRuby.initModel();
		minerSapphire.initModel();
		minerWood.initModel();
		minerStone.initModel();
		minerIron.initModel();
		minerGold.initModel();
		minerDiamond.initModel();
		
		farmerOpal.initModel();
		farmerTopaz.initModel();
		farmerRuby.initModel();
		farmerSapphire.initModel();
		farmerWood.initModel();
		farmerStone.initModel();
		farmerIron.initModel();
		farmerGold.initModel();
		farmerDiamond.initModel();
		
		multiOpal.initModel();
		multiTopaz.initModel();
		multiRuby.initModel();
		multiSapphire.initModel();
		multiWood.initModel();
		multiStone.initModel();
		multiIron.initModel();
		multiGold.initModel();
		multiDiamond.initModel();
		
		strengthPickaxe.initModel();
		strengthShovel.initModel();
		strengthAxe.initModel();
		strengthSword.initModel();
		
		speedSword.initModel();
		
		fireSword.initModel();
		firePickaxe.initModel();
		fireAxe.initModel();
		fireShovel.initModel();
		
		healSword.initModel();
		healAxe.initModel();
	}
}
