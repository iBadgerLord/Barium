package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.world.generation.feature.BariumFeatures;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class GenerationRegistry {

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Barium.modid, id), feature);
    }

    public static void registerFeatures() {

        ConfiguredFeature<?, ?> floweringMulberryTree = register("flowering_mulberry_tree", Feature.TREE.configure(BariumFeatures.floweringMulberryTree)
                .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(2)))
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
                .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.001F, 0))));

    }

    @SuppressWarnings("UnusedReturnValue")
    private static <C extends FeatureConfig, F extends Feature<C>> F register(String id, F feature) {
        return Registry.register(Registry.FEATURE, Barium.locate(Barium.modid), feature);
    }

    /*
    public static ConfiguredFeature<?, ?> marbleOverworld = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockRegistry.marble.getDefaultState(),
                    33))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    79)))
            .spreadHorizontally()
            .repeat(3);
     */

    public static void registerGeneration() {

        /*
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("barium", "marble_overworld"), marbleOverworld);
         */

    }

}
