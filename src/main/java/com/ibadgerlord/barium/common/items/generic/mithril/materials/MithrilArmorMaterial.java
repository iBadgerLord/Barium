package com.ibadgerlord.barium.common.items.generic.mithril.materials;

import com.ibadgerlord.barium.common.util.init.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MithrilArmorMaterial implements ArmorMaterial {

    private static final int[] baseDurability = new int[] {448, 632, 592, 512};
    private static final int[] protectionValues = new int[] {4, 7, 9, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDurability[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionValues[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.mithrilIngot);
    }

    @Override
    public String getName() {
        return "mithril";
    }

    @Override
    public float getToughness() {
        return 4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2f;
    }
}
