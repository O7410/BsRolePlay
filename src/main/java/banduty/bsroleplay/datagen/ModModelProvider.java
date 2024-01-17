package banduty.bsroleplay.datagen;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.HOLY_CLOUD_GENERATOR_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.JUDGE_HAMMER, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_BOOTS));

        itemModelGenerator.register(ModItems.POLICE_BATON, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_BOOTS));

        itemModelGenerator.register(ModItems.HOLY_WEAPON, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HALO));

        itemModelGenerator.register(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RED_PIRATE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RED_PIRATE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RED_PIRATE_LEGGINGS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLUE_PIRATE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLUE_PIRATE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BLUE_PIRATE_LEGGINGS));

        itemModelGenerator.register(ModItems.HOOK, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CROWN));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MINI_CROWN));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DREAM_MASK));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BUNNY_MASK));
    }
}
