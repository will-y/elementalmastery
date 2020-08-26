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

	public static final RegistryObject<EntityType<StrengthCreeperEntity>> STRENGTH_CREEPER = ENTITY_TYPES.register("strengthcreeper",
			() -> EntityType.Builder.create(StrengthCreeperEntity::new, EntityClassification.MONSTER)
					.size(1.0f, 2.0f) // Hitbox Size
					.build(new ResourceLocation(ElementalMastery.MODID, "strengthcreeper").toString()));
}
