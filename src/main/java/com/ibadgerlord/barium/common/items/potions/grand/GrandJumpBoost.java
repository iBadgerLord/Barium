package com.ibadgerlord.barium.common.items.potions.grand;

import com.ibadgerlord.barium.common.items.potions.PotionBase;
import com.ibadgerlord.barium.common.util.init.ItemRegistry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class GrandJumpBoost extends PotionBase {

    public GrandJumpBoost(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity && !((PlayerEntity)user).abilities.creativeMode) {
            stack.decrement(1);
        }

        if (!world.isClient) {

            List<StatusEffectInstance> effects = Arrays.asList(
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3600, 2));
            for (StatusEffectInstance effect : effects) {
                user.addStatusEffect(effect);
            }

        }


        return stack.isEmpty() ? new ItemStack(ItemRegistry.emptyGrandPotion) : stack;
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.barium.grand_jump_boost_potion.tooltip1").formatted(Formatting.BLUE) );
    }

}