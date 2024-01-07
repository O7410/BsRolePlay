package banduty.bsroleplay.entity.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HolyCloudRenderer extends MobEntityRenderer<HolyCloudEntity, HolyCloudModel<HolyCloudEntity>> {
    private static final Identifier TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/entity/holy_cloud.png");

    public HolyCloudRenderer(EntityRendererFactory.Context context) {
        super(context, new HolyCloudModel<>(context.getPart(ModModelLayers.HOLY_CLOUD)), 0.5f);
    }

    @Override
    public Identifier getTexture(HolyCloudEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(HolyCloudEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
