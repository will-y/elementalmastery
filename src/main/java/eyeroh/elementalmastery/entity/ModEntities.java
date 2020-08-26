package eyeroh.elementalmastery.entity;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ElementalMastery.MODID);

	// Entity Types
	public static final RegistryObject<EntityType<SpeedCreeperEntity>> SPEED_CREEPER = ENTITY_TYPES.register("speedcreeper",
			() -> EntityType.Builder.create(SpeedCreeperEntity::new, EntityClassification.MONSTER)
					.size(1.0f, 2.0f) // Hitbox Size
					.build(new ResourceLocation(ElementalMastery.MODID, "speedcreeper").toString()));


	public static void init() {
		int id = 1;

//		Biome[] biomes = BiomeDictionary.getBiomes(Type.BEACH).toArray(new Biome[BiomeDictionary.getBiomes(Type.BEACH).size()]);
//
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[BiomeDictionary.getBiomes(Type.FOREST).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.MESA).toArray(new Biome[BiomeDictionary.getBiomes(Type.MESA).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.PLAINS).toArray(new Biome[BiomeDictionary.getBiomes(Type.PLAINS).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.MOUNTAIN).toArray(new Biome[BiomeDictionary.getBiomes(Type.MOUNTAIN).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.HILLS).toArray(new Biome[BiomeDictionary.getBiomes(Type.HILLS).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[BiomeDictionary.getBiomes(Type.SWAMP).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SANDY).toArray(new Biome[BiomeDictionary.getBiomes(Type.SANDY).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SNOWY).toArray(new Biome[BiomeDictionary.getBiomes(Type.SNOWY).size()]));
//		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.WASTELAND).toArray(new Biome[BiomeDictionary.getBiomes(Type.WASTELAND).size()]));
//
//		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "strengthcreeper"), EntityStrengthCreeper.class, "StrengthCreeper", id++, ElementalMastery.instance, 64, 3, true, 0x00235b, 0x1d68e0);
//		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "speedcreeper"), EntitySpeedCreeper.class, "SpeedCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xda0bed, 0x860b91);
//		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "firecreeper"), EntityFireCreeper.class, "FireCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xf2860c, 0xa35b0b);
//		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "healcreeper"), EntityHealCreeper.class, "HealCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xff0000, 0xad1414);
//
//		EntityRegistry.addSpawn(EntityStrengthCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
//		EntityRegistry.addSpawn(EntitySpeedCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
//		EntityRegistry.addSpawn(EntityFireCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
//		EntityRegistry.addSpawn(EntityHealCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
//
//		LootTableList.register(EntityStrengthCreeper.LOOT);
//		LootTableList.register(EntitySpeedCreeper.LOOT);
//		LootTableList.register(EntityFireCreeper.LOOT);
//		LootTableList.register(EntityHealCreeper.LOOT);
		
		
	}
	
//	@SideOnly(Side.CLIENT)
//    public static void initModels() {
//        RenderingRegistry.registerEntityRenderingHandler(EntityStrengthCreeper.class, RenderStrengthCreeper.FACTORY);
//        RenderingRegistry.registerEntityRenderingHandler(EntitySpeedCreeper.class, RenderSpeedCreeper.FACTORY);
//        RenderingRegistry.registerEntityRenderingHandler(EntityFireCreeper.class, RenderFireCreeper.FACTORY);
//        RenderingRegistry.registerEntityRenderingHandler(EntityHealCreeper.class, RenderHealCreeper.FACTORY);
//  }
	
	
}
