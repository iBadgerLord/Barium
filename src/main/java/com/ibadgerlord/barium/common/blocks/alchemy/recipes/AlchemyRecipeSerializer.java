package com.ibadgerlord.barium.common.blocks.alchemy.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AlchemyRecipeSerializer implements RecipeSerializer<AlchemyRecipe> {

    public static final AlchemyRecipeSerializer INSTANCE = new AlchemyRecipeSerializer();

    public static final Identifier ID = new Identifier("barium:alchemy_table");

    @Override
    public AlchemyRecipe read(Identifier recipeId, JsonObject json) {
        AlchemyRecipeJsonFormat recipeJson = new Gson().fromJson(json, AlchemyRecipeJsonFormat.class);

        if (recipeJson.inputA == null
                || recipeJson.runeA == null
                || recipeJson.runeB == null
                || recipeJson.runeC == null
                || recipeJson.runeD == null
                || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }

        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient runeA = Ingredient.fromJson(recipeJson.runeA);
        Ingredient runeB = Ingredient.fromJson(recipeJson.runeB);
        Ingredient runeC = Ingredient.fromJson(recipeJson.runeC);
        Ingredient runeD = Ingredient.fromJson(recipeJson.runeD);

        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new AlchemyRecipe(inputA, runeA, runeB, runeC, runeD, output, recipeId);
    }

    @Override
    public void write(PacketByteBuf packetData, AlchemyRecipe recipe) {
        recipe.getInputA().write(packetData);
        recipe.getRuneA().write(packetData);
        recipe.getRuneB().write(packetData);
        recipe.getRuneC().write(packetData);
        recipe.getRuneD().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    public AlchemyRecipe read(Identifier recipeId, PacketByteBuf packetData) {
        Ingredient inputA = Ingredient.fromPacket(packetData);
        Ingredient runeA = Ingredient.fromPacket(packetData);
        Ingredient runeB = Ingredient.fromPacket(packetData);
        Ingredient runeC = Ingredient.fromPacket(packetData);
        Ingredient runeD = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new AlchemyRecipe(inputA, runeA, runeB, runeC, runeD, output, recipeId);
    }

    class AlchemyRecipeJsonFormat {

        JsonObject inputA;
        JsonObject runeA;
        JsonObject runeB;
        JsonObject runeC;
        JsonObject runeD;
        String outputItem;
        int outputAmount;

    }

}