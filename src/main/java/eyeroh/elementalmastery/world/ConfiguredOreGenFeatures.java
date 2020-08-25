package eyeroh.elementalmastery.world;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ConfiguredOreGenFeatures {
    public static ConfiguredFeature<?, ?> ORE_OPAL = newConfiguredFeature("ore_opal", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.OPAL_ORE.get().getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_TOPAZ = newConfiguredFeature("ore_topaz", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.TOPAZ_ORE.get().getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_RUBY = newConfiguredFeature("ore_ruby", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.RUBY_ORE.get().getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_SAPPHIRE = newConfiguredFeature("ore_sapphire", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.SAPPHIRE_ORE.get().getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));

    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(ElementalMastery.MODID, registryName), configuredFeature);
        return configuredFeature;
    }
}
