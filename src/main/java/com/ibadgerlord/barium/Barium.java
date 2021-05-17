package com.ibadgerlord.barium;

import com.ibadgerlord.barium.common.mixin.TreeDecoratorTypeRegisterInvoker;
import com.ibadgerlord.barium.common.util.RegistrationHelper;
import com.ibadgerlord.barium.common.util.init.*;
import com.ibadgerlord.barium.common.world.generation.feature.ConfiguredFeatures;
import com.ibadgerlord.barium.common.world.generation.feature.decorator.MulberryTreeDecorator;
import com.ibadgerlord.barium.common.world.generation.structure.structures.floatingIslands.FloatingArchipelagoStructure;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.tree.TreeDecoratorType;

public class Barium implements ModInitializer {

    public static final String modid = "barium";
    public static Identifier locate(String location) {
        return new Identifier(modid, location);
    }
    public static Identifier id(String name) {
        return new Identifier(modid, name);
    }

    public static final StructureFeature<StructurePoolFeatureConfig> floatingArchipelago = new FloatingArchipelagoStructure();

    private static void registerStructures() {

        FabricStructureBuilder.create(FloatingArchipelagoStructure.id, floatingArchipelago)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 423494938)
                .superflatFeature(ConfiguredFeatures.floatingArchipelago)
                .register();

    }

    public static void putStructures() {

        RegistrationHelper.addToBiome(
                FloatingArchipelagoStructure.id,
                BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_WARM_OCEAN).and(RegistrationHelper.booleanToPredicate(true)).and(BiomeSelectors.foundInOverworld()),
                (context) -> RegistrationHelper.addStructure(context, ConfiguredFeatures.floatingArchipelago)

        );

    }

    public static TreeDecoratorType<MulberryTreeDecorator> MULBERRY;
    public static final Identifier INTERACT_WITH_ALCHEMY_TABLE = new Identifier(modid, "interact_with_alchemy_table");

    @Override
    public void onInitialize() {

        Registry.register(Registry.CUSTOM_STAT, INTERACT_WITH_ALCHEMY_TABLE, INTERACT_WITH_ALCHEMY_TABLE);
        Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_ALCHEMY_TABLE);

        MULBERRY = TreeDecoratorTypeRegisterInvoker.invokeRegister("barium:mulberry", MulberryTreeDecorator.CODEC);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WOODED_HILLS), GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("barium", "flowering_mulberry_tree")));

        ArmorAndToolsRegistry.registerArmor();
        ArmorAndToolsRegistry.registerTools();
        BlockRegistry.registerBlocks();
        BlockRegistry.registerBlockItems();
        BlockRegistry.registerTransparent();
        ContainerRegistry.registerContainers();
        EntityRegistry.registerEntity();
        GenerationRegistry.registerGeneration();
        GenerationRegistry.registerFeatures();
        ItemRegistry.registerItems();
        ItemRegistry.registerPotions();


        registerStructures();
        ConfiguredFeatures.registerConfiguredFeatures();
        putStructures();

    }

}
