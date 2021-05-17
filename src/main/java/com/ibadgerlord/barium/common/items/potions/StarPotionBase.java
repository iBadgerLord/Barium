package com.ibadgerlord.barium.common.items.potions;

import com.ibadgerlord.barium.common.util.init.ItemRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public abstract class StarPotionBase extends Item {

    public StarPotionBase(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;

        if (playerEntity == null || !playerEntity.abilities.creativeMode) {
            stack.decrement(1);
        }

        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) playerEntity, stack);
        }

        if (!world.isClient) {
            runDrinkAction(stack, world, user, (ServerPlayerEntity) playerEntity);
        }

        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (playerEntity == null || !playerEntity.abilities.creativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(ItemRegistry.emptyStarPotion);
            }

            if (playerEntity != null) {
                playerEntity.inventory.insertStack(new ItemStack(ItemRegistry.emptyStarPotion));
            }
        }

        return stack;
    }

    public abstract void runDrinkAction(ItemStack stack, World world, LivingEntity user, ServerPlayerEntity playerEntity);

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
