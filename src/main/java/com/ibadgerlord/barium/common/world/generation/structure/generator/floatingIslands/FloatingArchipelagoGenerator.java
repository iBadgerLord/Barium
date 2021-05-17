package com.ibadgerlord.barium.common.world.generation.structure.generator.floatingIslands;

import com.google.common.collect.ImmutableList;
import com.ibadgerlord.barium.Barium;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.pool.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.List;

public class FloatingArchipelagoGenerator {

    public static final Identifier baseIsland = Barium.id("floating_islands/base");

    public static final Identifier spacingsUpperBase = Barium.id("floating_islands/spacings_upper_base");
    public static final Identifier spacingsBottomBase = Barium.id("floating_islands/spacings_bottom_base");
    public static final Identifier spacingsUnderBase = Barium.id("floating_islands/spacings_under_base");

    public static final Identifier islandsGrassy = Barium.id("floating_islands/islands_grassy");
    public static final Identifier islandsStone = Barium.id("floating_islands/islands_stone");

    public static final Identifier miniStones = Barium.id("floating_islands/mini_stones");

    public static final Identifier castlesBottom = Barium.id("floating_islands/castles_bottom");
    public static final Identifier castlesMid = Barium.id("floating_islands/castles_mid");

    public static final StructurePool startingPool;

    static {
        startingPool = StructurePools.register(
                new StructurePool(
                        baseIsland,
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/base/base_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/base/base_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/base/base_3"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/base/base_4_tower"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        islandsGrassy,
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_3"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_4"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_5"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_6"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_7"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_8"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_9"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_10"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_11"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/dirt_small_12"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        islandsStone,
                        new Identifier("empty"),
                        ImmutableList.of(

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_3"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_4"), 3),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_5"), 3),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/stone_small_6"), 3),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/iron_small_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/iron_small_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/iron_small_3"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/coal_small_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/coal_small_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/small/coal_small_3"), 1)

                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        miniStones,
                        new Identifier("empty"),
                        ImmutableList.of(

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_3"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_4"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_5"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_6"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_7"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_8"), 1),

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_9"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_10"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_11"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_12"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_13"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_14"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_15"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/islands/mini/stone_mini_16"), 1)

                                ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        spacingsUpperBase,
                        new Identifier("empty"),
                        ImmutableList.of(

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/cross"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/left_t"), 3),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/right_t"), 3),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/straight_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/straight_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/upper/straight_3"), 1)


                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        spacingsBottomBase,
                        new Identifier("empty"),
                        ImmutableList.of(

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/bottom/cross"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/bottom/left_t"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/bottom/right_t"), 2),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/bottom/straight"), 3)

                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        spacingsUnderBase,
                        new Identifier("empty"),
                        ImmutableList.of(

                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/under/mini_stone_side_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/under/mini_stone_side_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/spacings/under/mini_stone_side_3"), 1)

                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        castlesBottom,
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/bottom/tower_bottom_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/bottom/tower_bottom_2"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        castlesMid,
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/top/tower_top_alchemy_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/top/tower_top_alchemy_2"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/top/tower_top_library_1"), 1),
                                new Pair<>(StructurePoolElement.method_30425(Barium.modid + ":floating_islands/castles/top/tower_top_library_2"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );



    }

    public static void addPieces(DynamicRegistryManager registry, StructurePoolFeatureConfig config, ChunkGenerator chunkGenerator, StructureManager structureManager, BlockPos pos, List<StructurePiece> pieces, ChunkRandom random) {
        StructurePoolBasedGenerator.method_30419(registry, config, PoolStructurePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
    
}