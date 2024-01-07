package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.item.custom.HolySeeds;
import banduty.bsroleplay.item.custom.HolyWeapon;
import banduty.bsroleplay.item.custom.JudgeHammer;
import banduty.bsroleplay.item.custom.PirateArmorItem;
import banduty.bsroleplay.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC = registerItem("dolor_en_el_pecho_carola_music_disc",
            new MusicDiscItem(7, ModSounds.DOLOR_EN_EL_PECHO_CAROLA, new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1), 193));
    public static final Item HOLY_SEEDS = registerItem("holy_seeds",
            new HolySeeds(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item JUDGE_HAMMER = registerItem("judge_hammer",
            new JudgeHammer(new FabricItemSettings().maxCount(1).maxDamage(0).rarity(Rarity.RARE)));

    public static final Item POLICE_BATON = registerItem("police_baton",
            new SwordItem(ModToolMaterial.POLICE, 3, 1f, new FabricItemSettings().maxDamage(0).rarity(Rarity.UNCOMMON)));

    public static final Item HOLY_WEAPON = registerItem("holy_weapon",
            new HolyWeapon(new FabricItemSettings().maxCount(1).maxDamage(5).rarity(Rarity.EPIC)));

    public static final Item JUDGE_CHESTPLATE = registerItem("judge_chestplate",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item JUDGE_LEGGINGS = registerItem("judge_leggings",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item JUDGE_BOOTS = registerItem("judge_boots",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item POLICE_HELMET = registerItem("police_helmet",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item POLICE_CHESTPLATE = registerItem("police_chestplate",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item POLICE_LEGGINGS = registerItem("police_leggings",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item POLICE_BOOTS = registerItem("police_boots",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item HALO = registerItem("halo",
            new ArmorItem(ModArmorMaterials.HOLY, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item HOLY_CLOUD_SPAWN_EGG = registerItem("holy_cloud_spawn_egg",
            new SpawnEggItem(ModEntities.HOLY_CLOUD, 0xCDCDCD, 0xFCC861, new FabricItemSettings()));

    public static final Item PIRATE_HELMET = registerItem("pirate_helmet",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PIRATE_CHESTPLATE = registerItem("pirate_chestplate",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(HOLY_SEEDS);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BsRolePlay.LOGGER.info("Registering Mod Items for " + BsRolePlay.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}