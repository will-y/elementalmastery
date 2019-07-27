package eyeroh.elementalmastery;

import eyeroh.elementalmastery.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ElementalMastery.MODID, name = ElementalMastery.MODNAME, version = ElementalMastery.VERSION, dependencies = "", useMetadata = true)
public class ElementalMastery {

    public static final String MODID = "elementalmastery";
    public static final String MODNAME = "Elemental Mastery";
    public static final String VERSION = "1.3";

    @SidedProxy(clientSide = "eyeroh.elementalmastery.proxy.ClientProxy", serverSide = "eyeroh.elementalmastery.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ElementalMastery instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}