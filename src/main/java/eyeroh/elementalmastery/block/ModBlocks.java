package eyeroh.elementalmastery.block;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalMastery.MODID);

	public static final RegistryObject<Block> OPAL_BLOCK = BLOCKS.register("blockopal", GemBlock::new);
	public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("blocktopaz", GemBlock::new);
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("blockruby", GemBlock::new);
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("blocksapphire", GemBlock::new);

	public static final RegistryObject<Block> OPAL_ORE = BLOCKS.register("oreopal", OreBlock::new);
	public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("oretopaz", OreBlock::new);
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("oreruby", OreBlock::new);
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("oresapphire", OreBlock::new);
}