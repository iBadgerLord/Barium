package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.blocks.alchemy.AlchemyTableEntity;
import com.ibadgerlord.barium.common.blocks.alchemy.recipes.AlchemyRecipe;
import com.ibadgerlord.barium.common.blocks.alchemy.recipes.AlchemyRecipeSerializer;
import com.ibadgerlord.barium.common.blocks.alchemy.screen.AlchemyTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.ibadgerlord.barium.common.util.init.BlockRegistry.alchemyTable;

public class ContainerRegistry {

    public static final BlockEntityType<AlchemyTableEntity> alchemyEntity;
    public static final ScreenHandlerType<AlchemyTableScreenHandler> alchemyTableScreenHandler;

    static {

        alchemyEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("barium", "alchemy_table"), BlockEntityType.Builder.create(AlchemyTableEntity::new, alchemyTable).build(null));
        alchemyTableScreenHandler = ScreenHandlerRegistry.registerSimple(new Identifier(Barium.modid, "alchemy_table"), AlchemyTableScreenHandler::new);

    }

    public static void registerContainers() {

        Registry.register(Registry.RECIPE_SERIALIZER, AlchemyRecipeSerializer.ID,
                AlchemyRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier("barium", AlchemyRecipe.Type.ID), AlchemyRecipe.Type.INSTANCE);

    }

}
