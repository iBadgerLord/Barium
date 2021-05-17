package com.ibadgerlord.barium.common.blocks.alchemy;

import com.ibadgerlord.barium.common.blocks.alchemy.screen.AlchemyTableScreenHandler;
import com.ibadgerlord.barium.common.blocks.alchemy.screen.ImplementedInventory;
import com.ibadgerlord.barium.common.util.init.ContainerRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class AlchemyTableEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);

    public static final int slot_inputA = 0;
    public static final int slot_runeA = 1;
    public static final int slot_runeB = 2;
    public static final int slot_runeC = 3;
    public static final int slot_runeD = 4;
    public static final int slot_output = 5;

    private static final int[] runeSlots = new int[] {slot_runeA, slot_runeB, slot_runeC, slot_runeD};

    public AlchemyTableEntity() {
        super(ContainerRegistry.alchemyEntity);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;

    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlchemyTableScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

}