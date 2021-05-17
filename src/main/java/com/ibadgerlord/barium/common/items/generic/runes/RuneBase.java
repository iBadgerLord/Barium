package com.ibadgerlord.barium.common.items.generic.runes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RuneBase extends Item {

    public RuneBase(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
