package com.ibadgerlord.barium.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
public class SlabBase extends SlabBlock {
    public final Block baseBlock;

    public SlabBase(Settings settings, Block baseBlock) {
        super(settings);
        this.baseBlock = baseBlock;
    }

}