package com.ibadgerlord.barium.common.blocks.alchemy.recipes;

import com.ibadgerlord.barium.common.blocks.alchemy.AlchemyTableEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AlchemyRecipe implements Recipe<Inventory> {

    private final Ingredient inputA;
    private final Ingredient runeA;
    private final Ingredient runeB;
    private final Ingredient runeC;
    private final Ingredient runeD;

    private final ItemStack result;
    private final Identifier id;

    public AlchemyRecipe(Ingredient inputA, Ingredient runeA, Ingredient runeB, Ingredient runeC, Ingredient runeD, ItemStack result, Identifier id) {

        this.id = id;

        this.inputA = inputA;
        this.runeA = runeA;
        this.runeB = runeB;
        this.runeC = runeC;
        this.runeD = runeD;

        this.result = result;

    }

    public Ingredient getInputA() {
        return this.inputA;
    }

    public Ingredient getRuneA() {
        return this.runeA;
    }

    public Ingredient getRuneB() {
        return this.runeB;
    }

    public Ingredient getRuneC() {
        return this.runeC;
    }

    public Ingredient getRuneD() {
        return this.runeD;
    }

    @Override
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AlchemyRecipeSerializer.INSTANCE;
    }

    public static class Type implements RecipeType<AlchemyRecipe> {

        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "alchemy_recipe";

    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        return this.inputA.test(inv.getStack(AlchemyTableEntity.slot_inputA)) &&
                this.runeA.test(inv.getStack(AlchemyTableEntity.slot_runeA)) &&
                this.runeB.test(inv.getStack(AlchemyTableEntity.slot_runeB)) &&
                this.runeC.test(inv.getStack(AlchemyTableEntity.slot_runeC)) &&
                this.runeD.test(inv.getStack(AlchemyTableEntity.slot_runeD));
    }

    @Override
    public ItemStack craft(Inventory inv) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

}