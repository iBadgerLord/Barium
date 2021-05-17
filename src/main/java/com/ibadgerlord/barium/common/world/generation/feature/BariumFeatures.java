package com.ibadgerlord.barium.common.world.generation.feature;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.util.init.BlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import static com.ibadgerlord.barium.common.world.generation.feature.tree.BasicTree.basicTree;

public class BariumFeatures {

    public static final TreeFeatureConfig floweringMulberryTree = basicTree(Blocks.OAK_LOG, BlockRegistry.mulberryLeaves, 5);

    @SuppressWarnings("UnusedReturnValue")
    private static <C extends FeatureConfig, F extends Feature<C>> F register(F feature) {
        return Registry.register(Registry.FEATURE, Barium.modid, feature);
    }


}
