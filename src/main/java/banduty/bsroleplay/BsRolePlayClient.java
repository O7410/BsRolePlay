package banduty.bsroleplay;

import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.block.entity.renderer.HolyCloudGeneratorBlockEntityRenderer;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.entity.client.HolyCloudModel;
import banduty.bsroleplay.entity.client.HolyCloudRenderer;
import banduty.bsroleplay.entity.client.ModModelLayers;
import banduty.bsroleplay.screen.HolyCloudGeneratorScreen;
import banduty.bsroleplay.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.HOLY_CLOUD, HolyCloudRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HOLY_CLOUD, HolyCloudModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.HOLY_CLOUD_GENERATOR_SCREEN_HANDLER, HolyCloudGeneratorScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.HOLY_CLOUD_GENERATOR_STATION_BLOCK_ENTITY, HolyCloudGeneratorBlockEntityRenderer::new);
    }
}
