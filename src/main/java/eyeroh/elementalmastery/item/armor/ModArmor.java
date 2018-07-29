package eyeroh.elementalmastery.item.armor;

import eyeroh.elementalmastery.item.tool.GemPickaxe;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmor {
	
	public static ArmorMaterial ARMORMATERIALOPAL = EnumHelper.addArmorMaterial("ARMORMATERIALOPAL", "elementalmastery:armoropal", 700, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALTOPAZ = EnumHelper.addArmorMaterial("ARMORMATERIALTOPAZ", "elementalmastery:armortopaz", 700, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALRUBY = EnumHelper.addArmorMaterial("ARMORMATERIALRUBY", "elementalmastery:armorruby", 700, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALSAPPHIRE = EnumHelper.addArmorMaterial("ARMORMATERIALSAPPHIRE", "elementalmastery:armorsapphire", 700, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	
	public static ArmorMaterial ARMORMATERIALSPEED = EnumHelper.addArmorMaterial("ARMORMATERIALSPEED", "elementalmastery:armoropal", 1000, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALFIRE = EnumHelper.addArmorMaterial("ARMORMATERIALFIRE", "elementalmastery:armortopaz", 1000, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALHEAL = EnumHelper.addArmorMaterial("ARMORMATERIALHEAL", "elementalmastery:armorruby", 1000, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	public static ArmorMaterial ARMORMATERIALSTRENGTH = EnumHelper.addArmorMaterial("ARMORMATERIALSTRENGTH", "elementalmastery:armorsapphire", 1000, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetopal")
	public static GemArmor helmetOpal;
	@GameRegistry.ObjectHolder("elementalmastery:chestplateopal")
	public static GemArmor chestplateOpal;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsopal")
	public static GemArmor leggingsOpal;
	@GameRegistry.ObjectHolder("elementalmastery:bootsopal")
	public static GemArmor bootsOpal;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmettopaz")
	public static GemArmor helmetTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:chestplatetopaz")
	public static GemArmor chestplateTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:leggingstopaz")
	public static GemArmor leggingsTopaz;
	@GameRegistry.ObjectHolder("elementalmastery:bootstopaz")
	public static GemArmor bootsTopaz;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetruby")
	public static GemArmor helmetRuby;
	@GameRegistry.ObjectHolder("elementalmastery:chestplateruby")
	public static GemArmor chestplateRuby;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsruby")
	public static GemArmor leggingsRuby;
	@GameRegistry.ObjectHolder("elementalmastery:bootsruby")
	public static GemArmor bootsRuby;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetsapphire")
	public static GemArmor helmetSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:chestplatesapphire")
	public static GemArmor chestplateSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:leggingssapphire")
	public static GemArmor leggingsSapphire;
	@GameRegistry.ObjectHolder("elementalmastery:bootssapphire")
	public static GemArmor bootsSapphire;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetspeed")
	public static SpecialArmor helmetSpeed;
	@GameRegistry.ObjectHolder("elementalmastery:chestplatespeed")
	public static SpecialArmor chestplateSpeed;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsspeed")
	public static SpecialArmor leggingsSpeed;
	@GameRegistry.ObjectHolder("elementalmastery:bootsspeed")
	public static SpecialArmor bootsSpeed;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetfire")
	public static SpecialArmor helmetFire;
	@GameRegistry.ObjectHolder("elementalmastery:chestplatefire")
	public static SpecialArmor chestplateFire;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsfire")
	public static SpecialArmor leggingsFire;
	@GameRegistry.ObjectHolder("elementalmastery:bootsfire")
	public static SpecialArmor bootsFire;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetheal")
	public static SpecialArmor helmetHeal;
	@GameRegistry.ObjectHolder("elementalmastery:chestplateheal")
	public static SpecialArmor chestplateHeal;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsheal")
	public static SpecialArmor leggingsHeal;
	@GameRegistry.ObjectHolder("elementalmastery:bootsheal")
	public static SpecialArmor bootsHeal;
	
	@GameRegistry.ObjectHolder("elementalmastery:helmetstrength")
	public static SpecialArmor helmetStrength;
	@GameRegistry.ObjectHolder("elementalmastery:chestplatestrength")
	public static SpecialArmor chestplateStrength;
	@GameRegistry.ObjectHolder("elementalmastery:leggingsstrength")
	public static SpecialArmor leggingsStrength;
	@GameRegistry.ObjectHolder("elementalmastery:bootsstrength")
	public static SpecialArmor bootsStrength;
	
	public static void initModels() {
		helmetOpal.initModel();
		chestplateOpal.initModel();
		leggingsOpal.initModel();
		bootsOpal.initModel();
		
		helmetTopaz.initModel();
		chestplateTopaz.initModel();
		leggingsTopaz.initModel();
		bootsTopaz.initModel();
		
		helmetRuby.initModel();
		chestplateRuby.initModel();
		leggingsRuby.initModel();
		bootsRuby.initModel();
		
		helmetSapphire.initModel();
		chestplateSapphire.initModel();
		leggingsSapphire.initModel();
		bootsSapphire.initModel();
		
		helmetSpeed.initModel();
		chestplateSpeed.initModel();
		leggingsSpeed.initModel();
		bootsSpeed.initModel();
		
		helmetFire.initModel();
		chestplateFire.initModel();
		leggingsFire.initModel();
		bootsFire.initModel();
		
		helmetHeal.initModel();
		chestplateHeal.initModel();
		leggingsHeal.initModel();
		bootsHeal.initModel();
		
		helmetStrength.initModel();
		chestplateStrength.initModel();
		leggingsStrength.initModel();
		bootsStrength.initModel();
	}
}
