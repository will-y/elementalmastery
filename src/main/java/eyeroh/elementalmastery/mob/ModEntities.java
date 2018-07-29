package eyeroh.elementalmastery.mob;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.immutable.Stream;

import static net.minecraftforge.common.BiomeDictionary.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ModEntities {
	public static void init() {
		int id = 1;

		Biome[] biomes = BiomeDictionary.getBiomes(Type.BEACH).toArray(new Biome[BiomeDictionary.getBiomes(Type.BEACH).size()]);
		 
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[BiomeDictionary.getBiomes(Type.FOREST).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.MESA).toArray(new Biome[BiomeDictionary.getBiomes(Type.MESA).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.PLAINS).toArray(new Biome[BiomeDictionary.getBiomes(Type.PLAINS).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.MOUNTAIN).toArray(new Biome[BiomeDictionary.getBiomes(Type.MOUNTAIN).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.HILLS).toArray(new Biome[BiomeDictionary.getBiomes(Type.HILLS).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[BiomeDictionary.getBiomes(Type.SWAMP).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SANDY).toArray(new Biome[BiomeDictionary.getBiomes(Type.SANDY).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.SNOWY).toArray(new Biome[BiomeDictionary.getBiomes(Type.SNOWY).size()]));
		biomes = ArrayUtils.addAll(biomes, BiomeDictionary.getBiomes(Type.WASTELAND).toArray(new Biome[BiomeDictionary.getBiomes(Type.WASTELAND).size()]));
		
		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "strengthcreeper"), EntityStrengthCreeper.class, "StrengthCreeper", id++, ElementalMastery.instance, 64, 3, true, 0x00235b, 0x1d68e0);
		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "speedcreeper"), EntitySpeedCreeper.class, "SpeedCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xda0bed, 0x860b91);
		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "firecreeper"), EntityFireCreeper.class, "FireCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xf2860c, 0xa35b0b);
		EntityRegistry.registerModEntity(new ResourceLocation(ElementalMastery.MODID, "healcreeper"), EntityHealCreeper.class, "HealCreeper", id++, ElementalMastery.instance, 64, 3, true, 0xff0000, 0xad1414);
		
		EntityRegistry.addSpawn(EntityStrengthCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
		EntityRegistry.addSpawn(EntitySpeedCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
		EntityRegistry.addSpawn(EntityFireCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
		EntityRegistry.addSpawn(EntityHealCreeper.class, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
		
		LootTableList.register(EntityStrengthCreeper.LOOT);
		LootTableList.register(EntitySpeedCreeper.LOOT);
		LootTableList.register(EntityFireCreeper.LOOT);
		LootTableList.register(EntityHealCreeper.LOOT);
		
		
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityStrengthCreeper.class, RenderStrengthCreeper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySpeedCreeper.class, RenderSpeedCreeper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFireCreeper.class, RenderFireCreeper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityHealCreeper.class, RenderHealCreeper.FACTORY);
    }
	
	
}
