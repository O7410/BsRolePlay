package banduty.bsroleplay.compat;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.recipe.HolyCloudGeneratorRecipe;
import banduty.bsroleplay.screen.HolyCloudGeneratorScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class BsRolePlayREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new HolyCloudGeneratorCategory());

        registry.addWorkstations(HolyCloudGeneratorCategory.HOLY_CLOUD_GENERATOR, EntryStacks.of(ModBlocks.HOLY_CLOUD_GENERATOR_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(HolyCloudGeneratorRecipe.class, HolyCloudGeneratorRecipe.Type.INSTANCE,
                HolyCloudGeneratorDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), HolyCloudGeneratorScreen.class,
                HolyCloudGeneratorCategory.HOLY_CLOUD_GENERATOR);
    }
}