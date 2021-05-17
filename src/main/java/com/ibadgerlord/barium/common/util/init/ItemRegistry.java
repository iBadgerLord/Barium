package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.common.items.generic.runes.RuneBase;
import com.ibadgerlord.barium.common.items.potions.cursed.CursedPoison;
import com.ibadgerlord.barium.common.items.potions.cursed.CursedSlowness;
import com.ibadgerlord.barium.common.items.potions.cursed.CursedUnlucky;
import com.ibadgerlord.barium.common.items.potions.cursed.CursedWeakness;
import com.ibadgerlord.barium.common.items.potions.grand.*;
import com.ibadgerlord.barium.common.items.potions.star.StarGliding;
import com.ibadgerlord.barium.common.items.potions.star.StarRecall;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static final Item mulberries = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(64).food(new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.4F).build()));
    public static final Item mulberryPie = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(64).food(new FoodComponent.Builder()
            .hunger(6).saturationModifier(4F).build()));

    /*
    public static final Item cocoon = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkThread = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));

    public static final Item silkBlack = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkBlue = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkBrown = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkCyan = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkGray = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkGreen = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkLightBlue = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkLightGray = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkLime = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkMagenta = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkOrange = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkPink = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkPurple = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkRed = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkWhite = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item silkYellow = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
     */

    public static final Item mithrilScrap = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
    public static final Item mithrilIngot = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));

    public static final RuneBase runeLight = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeDark = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeFire = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeWater = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeGrass = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeElectric = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeFairy = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
    public static final RuneBase runeDragon = new RuneBase(new Item.Settings().group(ItemGroup.MISC).maxCount(16));

    public static void registerItems() {

        Registry.register(Registry.ITEM,new Identifier("barium", "mulberries"), mulberries);
        Registry.register(Registry.ITEM,new Identifier("barium", "mulberry_pie"), mulberryPie);

        /*
        Registry.register(Registry.ITEM,new Identifier("barium", "cocoon"), cocoon);
        Registry.register(Registry.ITEM,new Identifier("barium", "silk_thread"), silkThread);

        Registry.register(Registry.ITEM,new Identifier("barium", "black_silk"), silkBlack);
        Registry.register(Registry.ITEM,new Identifier("barium", "blue_silk"), silkBlue);
        Registry.register(Registry.ITEM,new Identifier("barium", "brown_silk"), silkBrown);
        Registry.register(Registry.ITEM,new Identifier("barium", "cyan_silk"), silkCyan);
        Registry.register(Registry.ITEM,new Identifier("barium", "gray_silk"), silkGray);
        Registry.register(Registry.ITEM,new Identifier("barium", "green_silk"), silkGreen);
        Registry.register(Registry.ITEM,new Identifier("barium", "light_blue_silk"), silkLightBlue);
        Registry.register(Registry.ITEM,new Identifier("barium", "light_gray_silk"), silkLightGray);
        Registry.register(Registry.ITEM,new Identifier("barium", "lime_silk"), silkLime);
        Registry.register(Registry.ITEM,new Identifier("barium", "magenta_silk"), silkMagenta);
        Registry.register(Registry.ITEM,new Identifier("barium", "orange_silk"), silkOrange);
        Registry.register(Registry.ITEM,new Identifier("barium", "pink_silk"), silkPink);
        Registry.register(Registry.ITEM,new Identifier("barium", "purple_silk"), silkPurple);
        Registry.register(Registry.ITEM,new Identifier("barium", "red_silk"), silkRed);
        Registry.register(Registry.ITEM,new Identifier("barium", "white_silk"), silkWhite);
        Registry.register(Registry.ITEM,new Identifier("barium", "yellow_silk"), silkYellow);
         */

        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_scrap"), mithrilScrap);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_ingot"), mithrilIngot);

        Registry.register(Registry.ITEM,new Identifier("barium", "light_rune"), runeLight);
        Registry.register(Registry.ITEM,new Identifier("barium", "dark_rune"), runeDark);
        Registry.register(Registry.ITEM,new Identifier("barium", "fire_rune"), runeFire);
        Registry.register(Registry.ITEM,new Identifier("barium", "water_rune"), runeWater);
        Registry.register(Registry.ITEM,new Identifier("barium", "grass_rune"), runeGrass);
        Registry.register(Registry.ITEM,new Identifier("barium", "electric_rune"), runeElectric);
        Registry.register(Registry.ITEM,new Identifier("barium", "fairy_rune"), runeFairy);
        Registry.register(Registry.ITEM,new Identifier("barium", "dragon_rune"), runeDragon);

    }

    public static final Item emptyGrandPotion = new Item(new Item.Settings().group(ItemGroup.BREWING).maxCount(16));
    public static final Item emptyCursedPotion = new Item(new Item.Settings().group(ItemGroup.BREWING).maxCount(16));
    public static final Item emptyStarPotion = new Item(new Item.Settings().group(ItemGroup.BREWING).maxCount(16));

    public static GrandRegeneration grandRegenarationPotion = new GrandRegeneration(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static GrandJumpBoost grandJumpBoostPotion = new GrandJumpBoost(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static GrandSpeed grandSpeedPotion = new GrandSpeed(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static GrandStrength grandStrengthPotion = new GrandStrength(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static GrandLuck grandLuckPotion = new GrandLuck(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));

    public static CursedSlowness cursedSlownessPotion = new CursedSlowness(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static CursedPoison cursedPoisonPotion = new CursedPoison(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static CursedWeakness cursedWeaknessPotion = new CursedWeakness(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static CursedUnlucky cursedUnluckyPotion = new CursedUnlucky(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));

    public static StarRecall recallPotion = new StarRecall(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));
    public static StarGliding glidingPotion = new StarGliding(new Item.Settings().group(ItemGroup.BREWING).maxCount(1));

    public static void registerPotions() {

        Registry.register(Registry.ITEM, new Identifier("barium", "grand_bottle"), emptyGrandPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "cursed_bottle"), emptyCursedPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "star_bottle"), emptyStarPotion);

        Registry.register(Registry.ITEM, new Identifier("barium", "grand_regeneration_potion"), grandRegenarationPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "grand_jump_boost_potion"), grandJumpBoostPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "grand_speed_potion"), grandSpeedPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "grand_strength_potion"), grandStrengthPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "grand_luck_potion"), grandLuckPotion);

        Registry.register(Registry.ITEM, new Identifier("barium", "cursed_slowness_potion"), cursedSlownessPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "cursed_poison_potion"), cursedPoisonPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "cursed_weakness_potion"), cursedWeaknessPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "cursed_unlucky_potion"), cursedUnluckyPotion);

        Registry.register(Registry.ITEM, new Identifier("barium", "recall_potion"), recallPotion);
        Registry.register(Registry.ITEM, new Identifier("barium", "gliding_potion"), glidingPotion);

    }

    //minecraft:chest[facing=east,type=left]{LootTable:"barium:chests/tower_alchemy_room"}

}
