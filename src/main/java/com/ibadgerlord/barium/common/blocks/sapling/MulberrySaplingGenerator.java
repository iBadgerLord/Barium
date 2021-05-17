package com.ibadgerlord.barium.common.blocks.sapling;

import com.ibadgerlord.barium.common.world.generation.feature.ConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class MulberrySaplingGenerator extends SaplingGenerator {

    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return (ConfiguredFeature<TreeFeatureConfig, ?>) ConfiguredFeatures.floweringMulberryTree;
    }
}
