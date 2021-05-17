package com.ibadgerlord.barium.common.blocks.alchemy.screen;

import com.ibadgerlord.barium.common.blocks.alchemy.recipes.AlchemyRecipe;
import com.ibadgerlord.barium.common.blocks.alchemy.screen.slots.OutputSlot;
import com.ibadgerlord.barium.common.util.init.ContainerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class AlchemyTableScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private AlchemyRecipe recipe = null;

    public AlchemyTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(6));
    }

    public AlchemyTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ContainerRegistry.alchemyTableScreenHandler, syncId);
        checkSize(inventory, 6);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int m;
        int l;

        this.addSlot(new Slot(inventory, 0, 80, 35)); //Item

        this.addSlot(new Slot(inventory, 1, 55, 17)); //Rune1
        this.addSlot(new Slot(inventory, 2, 105, 17)); //Rune2
        this.addSlot(new Slot(inventory, 3, 55, 53)); //Rune3
        this.addSlot(new Slot(inventory, 4, 105, 53)); //Rune4

        //this.addSlot(new OutputSlot(inventory, 5, 124, 35)); //Output

        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }

        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

}