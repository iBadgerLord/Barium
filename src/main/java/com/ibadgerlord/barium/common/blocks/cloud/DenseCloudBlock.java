package com.ibadgerlord.barium.common.blocks.cloud;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DenseCloudBlock extends BaseCloudBlock{

    public DenseCloudBlock() {
        super(FabricBlockSettings.of(Material.SNOW_BLOCK, MaterialColor.LIGHT_GRAY).sounds(BlockSoundGroup.SNOW).nonOpaque());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity.getVelocity().y <= 0.0F) entity.setVelocity(entity.getVelocity().multiply(1.0D, 0.005D, 1.0D));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f,0f,0f,1f,0.30f,1f);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return type == NavigationType.LAND;
    }

}
