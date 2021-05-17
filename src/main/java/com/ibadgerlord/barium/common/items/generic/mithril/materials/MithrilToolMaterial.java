package com.ibadgerlord.barium.common.items.generic.mithril.materials;

import com.ibadgerlord.barium.common.util.init.ItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MithrilToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 2438;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11;
    }

    @Override
    public float getAttackDamage() {
        return 9F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient()  {
        return Ingredient.ofItems(ItemRegistry.mithrilIngot);
    }

}
