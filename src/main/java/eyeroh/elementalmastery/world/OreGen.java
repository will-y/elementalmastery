package eyeroh.elementalmastery.world;

import java.util.Random;

import com.google.common.base.Predicate;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
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
