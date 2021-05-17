package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.common.entity.PossessedBookEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static final EntityType<PossessedBookEntity> possessedBookEntity = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("barium", "possessed_book"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PossessedBookEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static void registerEntity() {
        FabricDefaultAttributeRegistry.register(possessedBookEntity, PossessedBookEntity.createMobAttributes());
    }

}
