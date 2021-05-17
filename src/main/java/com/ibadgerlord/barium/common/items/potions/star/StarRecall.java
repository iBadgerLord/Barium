package com.ibadgerlord.barium.common.items.potions.star;

import com.ibadgerlord.barium.common.items.potions.StarPotionBase;
import net.minecraft.block.BedBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class StarRecall extends StarPotionBase {

    public StarRecall(Settings settings) {
        super(settings);
    }

    @Override
    public void runDrinkAction(ItemStack stack, World world, LivingEntity user, ServerPlayerEntity player) {
        BlockPos spawn = player.getSpawnPointPosition();

        if (spawn != null) {
            Vec3d spawnPos;

            // Run standard bed placement logic only if the player would spawn at a bed
            if(world.getBlockState(spawn).getBlock() instanceof BedBlock) {
                spawnPos = BedBlock.findWakeUpPosition(EntityType.PLAYER, world, spawn, 0).orElseGet(() -> {
                    BlockPos blockPos2 = spawn.up();
                    return new Vec3d((double) blockPos2.getX() + 0.5D, (double) blockPos2.getY() + 0.1D, (double) blockPos2.getZ() + 0.5D);
                });
            } else {
                BlockPos add = spawn.up().add(0.5D, 0, 0.5D);
                spawnPos = new Vec3d(add.getX(), add.getY(), add.getZ());
            }

            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            user.requestTeleport(spawnPos.x, spawnPos.y, spawnPos.z);
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.barium.recall_potion.tooltip1").formatted(Formatting.BLUE) );
    }
}
