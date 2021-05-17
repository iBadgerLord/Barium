package com.ibadgerlord.barium.common.world.generation.feature;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.util.RegistrationHelper;
import com.ibadgerlord.barium.common.world.generation.structure.generator.floatingIslands.FloatingArchipelagoGenerator;
import com.ibadgerlord.barium.common.world.generation.structure.structures.floatingIslands.FloatingArchipelagoStructure;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

public class ConfiguredFeatures {

    public static ConfiguredFeature<?, ?> floweringMulberryTree;

    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> floatingArchipelago = Barium.floatingArchipelago.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(FloatingArchipelagoGenerator.startingPool), 2));

    public static void registerConfiguredFeatures() {

        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, FloatingArchipelagoStructure.id, floatingArchipelago);

    }

}