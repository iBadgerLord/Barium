package com.ibadgerlord.barium.common.util.init;

import com.ibadgerlord.barium.common.items.generic.mithril.materials.*;
import com.ibadgerlord.barium.common.items.generic.mithril.tools.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorAndToolsRegistry {


    public static final ArmorMaterial mithrilArmorMaterial = new MithrilArmorMaterial();

    public static final Item mithrilHelmet = new ArmorItem(mithrilArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item mithrilChestplate = new ArmorItem(mithrilArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item mithrilLeggings = new ArmorItem(mithrilArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item mithrilBoots = new ArmorItem(mithrilArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).fireproof());

    public static void registerArmor() {

        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_helmet"), mithrilHelmet);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_chestplate"), mithrilChestplate);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_leggings"), mithrilLeggings);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_boots"), mithrilBoots);

    }

    public static final MithrilToolMaterial mithrilToolMaterial = new MithrilToolMaterial();

    public static ToolItem mithrilSword = new CustomSword(mithrilToolMaterial, -1, -1.4F, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static ToolItem mithrilShovel = new CustomShovel(mithrilToolMaterial, -2.5F, -2, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static ToolItem mithrilPickaxe = new CustomPickaxe(mithrilToolMaterial, -3, -1.8F, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static ToolItem mithrilAxe = new CustomAxe(mithrilToolMaterial, 1, -2, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static ToolItem mithrilHoe = new CustomHoe(mithrilToolMaterial, -8, 0, new Item.Settings().group(ItemGroup.TOOLS).fireproof());

    public static void registerTools() {

        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_sword"), mithrilSword);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_shovel"), mithrilShovel);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_pickaxe"), mithrilPickaxe);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_axe"), mithrilAxe);
        Registry.register(Registry.ITEM,new Identifier("barium", "mithril_hoe"), mithrilHoe);

    }

}
