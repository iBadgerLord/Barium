package com.ibadgerlord.barium.common.mixin;

import net.minecraft.server.network.ServerPlayerEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class PlayerArmorEquippedMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick (CallbackInfo info){

        ServerPlayerEntity playerEntity = (ServerPlayerEntity) (Object) this;

        /*
        if (playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ArmorRegistry.spruceHelmet &&
                playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ArmorRegistry.spruceChestplate &&
                playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ArmorRegistry.spruceLeggings &&
                playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == ArmorRegistry.spruceBoots) {

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));

        }

        if (playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ArmorRegistry.birchHelmet &&
                playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ArmorRegistry.birchChestplate &&
                playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ArmorRegistry.birchLeggings &&
                playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == ArmorRegistry.birchBoots) {

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));

        }

        if (playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ArmorRegistry.jungleHelmet &&
                playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ArmorRegistry.jungleChestplate &&
                playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ArmorRegistry.jungleLeggings &&
                playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == ArmorRegistry.jungleBoots) {

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));

        }

        if (playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ArmorRegistry.acaciaHelmet &&
                playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ArmorRegistry.acaciaChestplate &&
                playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ArmorRegistry.acaciaLeggings &&
                playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == ArmorRegistry.acaciaBoots) {

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));

        }

        if (playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ArmorRegistry.darkOakHelmet &&
                playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ArmorRegistry.darkOakChestplate &&
                playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ArmorRegistry.darkOakLeggings &&
                playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == ArmorRegistry.darkOakBoots) {

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));

        }
         */

    }

}
