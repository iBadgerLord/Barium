package com.ibadgerlord.barium.common.world.generation.feature.decorator;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.util.init.BlockRegistry;
import com.mojang.serialization.Codec;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class MulberryTreeDecorator extends TreeDecorator {

    public static final MulberryTreeDecorator INSTANCE = new MulberryTreeDecorator();

    public static final Codec<MulberryTreeDecorator> CODEC = Codec.unit(() -> {
        return INSTANCE;
    });

    @Override
    protected TreeDecoratorType<?> getType() {
        return Barium.MULBERRY;
    }

    @Override
    public void generate(StructureWorldAccess world, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions, Set<BlockPos> placedStates, BlockBox box) {
        leavesPositions.forEach((pos) -> {
            if (random.nextInt(8) == 0 && leavesPositions.contains(pos.up())) {
                this.setBlockStateAndEncompassPosition(world, pos, BlockRegistry.floweringMulberryLeaves.getStateManager().getDefaultState().with(LeavesBlock.DISTANCE, 1).with(LeavesBlock.PERSISTENT, false), placedStates, box);
            }
        });
    }

}
