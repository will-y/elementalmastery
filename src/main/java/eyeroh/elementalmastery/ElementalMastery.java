package eyeroh.elementalmastery;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.entity.ModEntities;
import eyeroh.elementalmastery.entity.SpeedCreeperEntity;
import eyeroh.elementalmastery.entity.StrengthCreeperEntity;
import eyeroh.elementalmastery.entity.render.SpeedCreeperRenderer;
import eyeroh.elementalmastery.entity.render.StrengthCreeperRenderer;
import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.item.armor.ModArmor;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.world.OreGen;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
        ModMachines.MACHINES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTools.TOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModArmor.ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        OreGen.addFeatures();
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntities.SPEED_CREEPER.get(), SpeedCreeperEntity.setCustomAttributes().func_233813_a_());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntities.STRENGTH_CREEPER.get(), StrengthCreeperEntity.setCustomAttributes().func_233813_a_());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SPEED_CREEPER.get(), SpeedCreeperRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.STRENGTH_CREEPER.get(), StrengthCreeperRenderer::new);
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