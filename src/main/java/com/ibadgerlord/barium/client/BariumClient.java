package com.ibadgerlord.barium.client;

import com.ibadgerlord.barium.client.renderer.PossessedBookRenderer;
import com.ibadgerlord.barium.common.blocks.alchemy.screen.AlchemyTableScreen;
import com.ibadgerlord.barium.common.util.init.ContainerRegistry;
import com.ibadgerlord.barium.common.util.init.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;


@Environment(EnvType.CLIENT)
public class BariumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenRegistry.register(ContainerRegistry.alchemyTableScreenHandler, AlchemyTableScreen::new);

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.possessedBookEntity, (dispatcher, context) -> {
            return new PossessedBookRenderer(dispatcher);

        });
    }
}
