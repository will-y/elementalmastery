package eyeroh.elementalmastery;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("elementalmastery")
public class ElementalMastery {

    public static final String MODID = "elementalmastery";
    public static final String MODNAME = "Elemental Mastery";
    public static final String VERSION = "1.3";

    public ElementalMastery() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

//    @SidedProxy(clientSide = "eyeroh.elementalmastery.proxy.ClientProxy", serverSide = "eyeroh.elementalmastery.proxy.ServerProxy")
//    public static CommonProxy proxy;
//
//    @Mod.Instance
//    public static ElementalMastery instance;
//
//    @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//        proxy.preInit(event);
//    }
//
//    @Mod.EventHandler
//    public void init(FMLInitializationEvent e) {
//        proxy.init(e);
//    }
//
//    @Mod.EventHandler
//    public void postInit(FMLPostInitializationEvent e) {
//        proxy.postInit(e);
//    }
}