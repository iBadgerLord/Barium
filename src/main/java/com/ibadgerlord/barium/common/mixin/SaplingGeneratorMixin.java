package com.ibadgerlord.barium.common.mixin;

import com.ibadgerlord.barium.common.world.generation.feature.ConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(SaplingGenerator.class)
public class SaplingGeneratorMixin {

    @ModifyVariable(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;"))
    private ConfiguredFeature<TreeFeatureConfig, ?> modifyFeature(ConfiguredFeature<TreeFeatureConfig, ?> originalValue, ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
        BlockPos ground = pos.down();
        BlockState groundState = world.getBlockState(ground);

        if (groundState.isOf(Blocks.DIRT)) {

            if (originalValue == ConfiguredFeatures.floweringMulberryTree) {
                return null;
            }

        }

        return originalValue;

    }
}
