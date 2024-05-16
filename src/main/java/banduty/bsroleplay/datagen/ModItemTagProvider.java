package banduty.bsroleplay.datagen;

import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.COINS)
                .add(ModItems.COPPER_COIN, ModItems.GOLD_COIN, ModItems.AMETHYST_COIN, ModItems.NETHERITE_COIN,
                        ModItems.COPPER_COIN_STACK, ModItems.GOLD_COIN_STACK, ModItems.AMETHYST_COIN_STACK, ModItems.NETHERITE_COIN_STACK);
    }
}
