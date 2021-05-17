package com.ibadgerlord.barium.common.world.generation.feature.tree;

import com.google.common.collect.ImmutableList;
import com.ibadgerlord.barium.common.world.generation.feature.decorator.MulberryTreeDecorator;
import net.minecraft.block.Block;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BasicTree {

    public static TreeFeatureConfig basicTree(Block trunk, Block leaves, int height) {
        return new TreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(trunk.getDefaultState()),
                new SimpleBlockStateProvider(leaves.getDefaultState()),
                new BlobFoliagePlacer(UniformIntDistribution.of(2, 0), UniformIntDistribution.of(0, 0), 3),
                new StraightTrunkPlacer(height, 2, 0),
                new TwoLayersFeatureSize(1, 0, 0)
        ).decorators(ImmutableList.of(MulberryTreeDecorator.INSTANCE)).ignoreVines().build();

    }

}
