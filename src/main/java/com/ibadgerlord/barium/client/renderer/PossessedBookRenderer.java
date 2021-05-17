package com.ibadgerlord.barium.client.renderer;

import com.ibadgerlord.barium.client.model.PossessedBookModel;
import com.ibadgerlord.barium.common.entity.PossessedBookEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PossessedBookRenderer extends MobEntityRenderer<PossessedBookEntity, PossessedBookModel> {

    public PossessedBookRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PossessedBookModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(PossessedBookEntity entity) {
        return new Identifier("barium", "textures/entity/possessed_book.png");
    }
}
