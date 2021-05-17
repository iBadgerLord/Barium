package com.ibadgerlord.barium.common.world.generation.structure.structures.floatingIslands;

import com.ibadgerlord.barium.Barium;
import com.ibadgerlord.barium.common.world.generation.structure.generator.floatingIslands.FloatingArchipelagoGenerator;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class FloatingArchipelagoStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public static final Identifier id = Barium.id("floating_archipelago");

    public FloatingArchipelagoStructure() {
        super(StructurePoolFeatureConfig.CODEC);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return FloatingArchipelagoStructure.Start::new;
    }

    public static class Start extends StructureStart<StructurePoolFeatureConfig> {

        public Start(StructureFeature<StructurePoolFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome, StructurePoolFeatureConfig config) {
            FloatingArchipelagoGenerator.addPieces(registryManager, config, chunkGenerator, structureManager, new BlockPos(x << 4, 100, z << 4), children, random);
            this.setBoundingBoxFromChildren();
        }

    }

}
