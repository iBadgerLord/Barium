package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.common.blocks.LargeVase;
import com.ibadgerlord.barium.common.blocks.RuneFrame;
import com.ibadgerlord.barium.common.blocks.SmallVase;
import com.ibadgerlord.barium.common.blocks.cloud.DenseCloudBlock;
import com.ibadgerlord.barium.common.blocks.cloud.NormalCloudBlock;
import com.ibadgerlord.barium.common.blocks.cloud.RainCloudBlock;
import com.ibadgerlord.barium.common.blocks.alchemy.AlchemyTable;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class BlockRegistry {

    public static final LeavesBlock mulberryLeaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).breakByTool(FabricToolTags.HOES).allowsSpawning(BlockRegistry::canSpawnOnLeaves).suffocates(BlockRegistry::never).blockVision(BlockRegistry::never));
    public static final LeavesBlock floweringMulberryLeaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).breakByTool(FabricToolTags.HOES).allowsSpawning(BlockRegistry::canSpawnOnLeaves).suffocates(BlockRegistry::never).blockVision(BlockRegistry::never));

    /*
    public static final BariumSaplingBlock floweringMulberrySapling = new BariumSaplingBlock(new com.ibadgerlord.barium.common.blocks.saplings.MulberrySaplingGenerator(), AbstractBlock
            .Settings.of(Material.PLANT)
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
            .noCollision());

    public static final Block marble = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block marbleBricks = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block polishedMarble = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block chiseledMarbleBricks = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block starlightInfusedMarble = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));

    public static final Block marbleStairs = new StairsBase(BlockRegistry.marble.getDefaultState(), FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block marbleBrickStairs = new StairsBase(BlockRegistry.marbleBricks.getDefaultState(), FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block polishedMarbleStairs = new StairsBase(BlockRegistry.polishedMarble.getDefaultState(), FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
     */

    public static final Block cloud = new NormalCloudBlock();
    public static final Block rainyCloud = new RainCloudBlock();
    public static final Block denseCloud = new DenseCloudBlock();

    public static final Block alchemyTable = new AlchemyTable(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block runeFrame = new RuneFrame(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.5f));
    public static final Block smallVase = new SmallVase(FabricBlockSettings.copyOf(Blocks.FLOWER_POT).breakByHand(true).sounds(BlockSoundGroup.STONE).hardness(0f));
    public static final Block largeVase = new LargeVase(FabricBlockSettings.copyOf(Blocks.FLOWER_POT).breakByHand(true).sounds(BlockSoundGroup.STONE).hardness(0f));

    public static final Block mithrilBlock = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(50f));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier("barium", "mulberry_leaves"), mulberryLeaves);
        Registry.register(Registry.BLOCK, new Identifier("barium", "flowering_mulberry_leaves"), floweringMulberryLeaves);

        /*
        Registry.register(Registry.BLOCK, new Identifier("barium", "flowering_mulberry_sapling"), floweringMulberrySapling);

        Registry.register(Registry.BLOCK, new Identifier("barium", "marble"), marble);
        Registry.register(Registry.BLOCK, new Identifier("barium", "marble_bricks"), marbleBricks);
        Registry.register(Registry.BLOCK, new Identifier("barium", "polished_marble"), polishedMarble);
        Registry.register(Registry.BLOCK, new Identifier("barium", "chiseled_marble_bricks"), chiseledMarbleBricks);
        Registry.register(Registry.BLOCK, new Identifier("barium", "starlight_infused_marble"), starlightInfusedMarble);

        Registry.register(Registry.BLOCK, new Identifier("barium", "marble_stairs"), marbleStairs);
        Registry.register(Registry.BLOCK, new Identifier("barium", "marble_brick_stairs"), marbleBrickStairs);
        Registry.register(Registry.BLOCK, new Identifier("barium", "polished_marble_stairs"), polishedMarbleStairs);
        */

        Registry.register(Registry.BLOCK, new Identifier("barium", "cloud"), cloud);
        Registry.register(Registry.BLOCK, new Identifier("barium", "rainy_cloud"), rainyCloud);
        Registry.register(Registry.BLOCK, new Identifier("barium", "dense_cloud"), denseCloud);

        Registry.register(Registry.BLOCK, new Identifier("barium", "alchemy_table"), alchemyTable);
        Registry.register(Registry.BLOCK, new Identifier("barium", "rune_frame"), runeFrame);
        Registry.register(Registry.BLOCK, new Identifier("barium", "small_vase"), smallVase);
        Registry.register(Registry.BLOCK, new Identifier("barium", "large_vase"), largeVase);

        Registry.register(Registry.BLOCK, new Identifier("barium", "mithril_block"), mithrilBlock);

        flammables();

    }

    public static void registerBlockItems () {

       Registry.register(Registry.ITEM, new Identifier("barium", "mulberry_leaves"), new BlockItem(mulberryLeaves, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "flowering_mulberry_leaves"), new BlockItem(floweringMulberryLeaves, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

       /*
       Registry.register(Registry.ITEM, new Identifier("barium", "flowering_mulberry_sapling"), new BlockItem(floweringMulberrySapling, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

       Registry.register(Registry.ITEM, new Identifier("barium", "marble"), new BlockItem(marble, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "marble_bricks"), new BlockItem(marbleBricks, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "polished_marble"), new BlockItem(polishedMarble, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "chiseled_marble_bricks"), new BlockItem(chiseledMarbleBricks, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "starlight_infused_marble"), new BlockItem(starlightInfusedMarble, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

       Registry.register(Registry.ITEM, new Identifier("barium", "marble_stairs"), new BlockItem(marbleStairs, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "marble_brick_stairs"), new BlockItem(marbleBrickStairs, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "polished_marble_stairs"), new BlockItem(polishedMarbleStairs, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        */

       Registry.register(Registry.ITEM, new Identifier("barium", "cloud"), new BlockItem(cloud, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "rainy_cloud"), new BlockItem(rainyCloud, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "dense_cloud"), new BlockItem(denseCloud, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

       Registry.register(Registry.ITEM, new Identifier("barium", "alchemy_table"), new BlockItem(alchemyTable, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "rune_frame"), new BlockItem(runeFrame, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "small_vase"), new BlockItem(smallVase, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
       Registry.register(Registry.ITEM, new Identifier("barium", "large_vase"), new BlockItem(largeVase, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

       Registry.register(Registry.ITEM, new Identifier("barium", "mithril_block"), new BlockItem(mithrilBlock, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    }

    public static void registerTransparent() {

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.cloud, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.rainyCloud, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.denseCloud, RenderLayer.getTranslucent());

    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    private static void flammables() {
        FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableRegistry.add(mulberryLeaves, 30, 60);
        flammableRegistry.add(floweringMulberryLeaves, 30, 60);

        /*
        flammableRegistry.add(floweringMulberrySapling, 100, 60);
         */
    }

}