package com.ibadgerlord.barium.common.items.generic.mithril.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CustomSword extends SwordItem {
    public CustomSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
