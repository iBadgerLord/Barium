package com.ibadgerlord.barium.common.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TreeDecoratorType.class)
public interface TreeDecoratorTypeRegisterInvoker {
    @Invoker("register")
    static <P extends TreeDecorator> TreeDecoratorType<P> invokeRegister(String id, Codec<P> codec) {
        throw new AssertionError();
    }
}