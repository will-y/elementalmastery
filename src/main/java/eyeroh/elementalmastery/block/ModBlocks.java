package eyeroh.elementalmastery.block;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalMastery.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalMastery.MODID);
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ElementalMastery.MODID);
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ElementalMastery.MODID);

	public static final RegistryObject<Block> OPAL_BLOCK = BLOCKS.register("blockopal", GemBlock::new);
	public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("blocktopaz", GemBlock::new);
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("blockruby", GemBlock::new);
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("blocksapphire", GemBlock::new);

	public static final RegistryObject<Block> OPAL_ORE = BLOCKS.register("oreopal", OreBlock::new);
	public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("oretopaz", OreBlock::new);
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("oreruby", OreBlock::new);
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("oresapphire", OreBlock::new);

	public static final RegistryObject<Item> OPAL_BLOCK_ITEM = ITEMS.register("blockopal", () -> new BlockItem(OPAL_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> TOPAZ_BLOCK_ITEM = ITEMS.register("blocktopaz", () -> new BlockItem(TOPAZ_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("blockruby", () -> new BlockItem(RUBY_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("blocksapphire", () -> new BlockItem(SAPPHIRE_BLOCK.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));

	public static final RegistryObject<Item> OPAL_ORE_ITEM = ITEMS.register("oreopal", () -> new BlockItem(ModBlocks.OPAL_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> TOPAZ_ORE_ITEM = ITEMS.register("oretopaz", () -> new BlockItem(ModBlocks.TOPAZ_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("oreruby", () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("oresapphire", () -> new BlockItem(ModBlocks.SAPPHIRE_ORE.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));

	public static final RegistryObject<BlockGemChest> CHEST_OPAL = BLOCKS.register("chestopal", BlockGemChest::new);
	public static final RegistryObject<Item> CHEST_OPAL_ITEM = ITEMS.register("chestopal", () -> new BlockItem(CHEST_OPAL.get(), new Item.Properties().group(CreativeTabs.tabGemBlocks)));
	public static final RegistryObject<TileEntityType<TileGemChest>> CHEST_OPAL_TILE = TILES.register("chestopal", () -> TileEntityType.Builder.create(TileGemChest::new, CHEST_OPAL.get()).build(null));

	public static final RegistryObject<ContainerType<ContainerGemChest>> CHEST_OPAL_CONTAINER = CONTAINERS.register("chestopal", () -> IForgeContainerType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		World world = inv.player.getEntityWorld();
		return new ContainerGemChest(windowId, world, pos, inv, inv.player);
	}));
}