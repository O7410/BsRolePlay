package banduty.bsroleplay;

import banduty.bsroleplay.screen.HolyCloudGeneratorScreen;
import banduty.bsroleplay.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.HOLY_CLOUD_GENERATOR_SCREEN_HANDLER, HolyCloudGeneratorScreen::new);
    }
}
