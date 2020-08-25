package eyeroh.elementalmastery.world;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.base.Predicate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.xml.bind.Element;

@Mod.EventBusSubscriber(modid = ElementalMastery.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {



    // Taken from https://github.com/CorgiTaco/BYG/blob/f92444662038c0e88f95c3ba13c55f792d9a8cbf/src/main/java/voronoiaoc/byg/common/world/feature/biomefeatures/BYGFeaturesInVanilla.java#L17
    // Temp worldgen workaround
    public static void addFeatures() {
        for (Biome biome : WorldGenRegistries.field_243657_i) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredOreGenFeatures.ORE_OPAL);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredOreGenFeatures.ORE_TOPAZ);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredOreGenFeatures.ORE_RUBY);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredOreGenFeatures.ORE_SAPPHIRE);
            }
        }
    }


    //Use these to add our features to vanilla's biomes.
    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) {
        ConvertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.func_242440_e().field_242484_f;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);

    }

    private static void ConvertImmutableFeatures(Biome biome) {
        if (biome.func_242440_e().field_242484_f instanceof ImmutableList) {
            biome.func_242440_e().field_242484_f = biome.func_242440_e().field_242484_f.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    }

//	@SubscribeEvent
//	public static void generateOres(FMLLoadCompleteEvent event) {
//		for (Biome biome : ForgeRegistries.BIOMES) {
//
//			if (biome.getCategory() == Biome.Category.NETHER) {
//				//Nether Generation
//			} else if (biome.getCategory() == Biome.Category.THEEND) {
//				//End Generation
//			} else {
//				//World Generation
//				genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.OPAL_ORE.get().getDefaultState(), 6);
//			}
//		}
//	}
//
//	private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
//		CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
//		OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
//		ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
//		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
//	}

//	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkgenerator, IChunkProvider chunkProvider) {
//		switch(world.provider.getDimension()) {
//		case -1:
//
//			break;
//		case 0:
//			runGenerator(ModBlocks.oreopal.getDefaultState(), 5, 3, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
//			runGenerator(ModBlocks.oretopaz.getDefaultState(), 5, 3, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
//			runGenerator(ModBlocks.oreruby.getDefaultState(), 5, 3, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
//			runGenerator(ModBlocks.oresapphire.getDefaultState(), 5, 3, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
//			break;
//		case 1:
//
//			break;
//		default:
//
//			break;
//		}
//	}
//
//	private void runGenerator(IBlockState blockToGen, int blockAmount,  int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z){
//		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
//			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
//
//		WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
//		int heightdiff = maxHeight - minHeight +1;
//		for (int i=0; i<chancesToSpawn; i++){
//			int x = chunk_X * 16 +rand.nextInt(16);
//			int y = minHeight + rand.nextInt(heightdiff);
//			int z = chunk_Z * 16 + rand.nextInt(16);
//
//			generator.generate(world, rand, new BlockPos(x, y, z));
//		}
//	}
}
