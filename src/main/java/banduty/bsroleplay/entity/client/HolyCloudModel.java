package banduty.bsroleplay.entity.client;

import banduty.bsroleplay.entity.animation.ModAnimations;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class HolyCloudModel<T extends HolyCloudEntity> extends SinglePartEntityModel<T> {
	private final ModelPart holy_cloud;
	private final ModelPart head;

	public HolyCloudModel(ModelPart root) {
		this.holy_cloud = root.getChild("holy_cloud");
		this.head = holy_cloud.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData holy_cloud = modelPartData.addChild("holy_cloud", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = holy_cloud.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData principal = body.addChild("principal", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -11.0F, -10.0F, 18.0F, 8.0F, 24.0F, new Dilation(0.0F))
				.uv(26, 34).cuboid(-9.0F, -13.0F, -8.0F, 2.0F, 2.0F, 22.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(7.0F, -13.0F, -10.0F, 2.0F, 2.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wing_left = principal.addChild("wing_left", ModelPartBuilder.create().uv(60, 0).cuboid(9.0F, -13.0F, -6.0F, 2.0F, 7.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wing_right = principal.addChild("wing_right", ModelPartBuilder.create().uv(29, 61).cuboid(-11.0F, -13.0F, -6.0F, 2.0F, 7.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData details = body.addChild("details", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData layer_1 = details.addChild("layer_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData T = layer_1.addChild("T", ModelPartBuilder.create().uv(56, 51).cuboid(3.0F, -13.0F, -6.0F, 4.0F, 2.0F, 18.0F, new Dilation(0.0F))
				.uv(0, 56).cuboid(-7.0F, -13.0F, -8.0F, 4.0F, 2.0F, 18.0F, new Dilation(0.0F))
				.uv(63, 71).cuboid(-3.0F, -13.0F, -3.0F, 6.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData details_layer_1 = layer_1.addChild("details_layer_1", ModelPartBuilder.create().uv(0, 11).cuboid(3.0F, -12.0F, 12.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 8).cuboid(-9.0F, -12.0F, -10.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 37).cuboid(-7.0F, -12.0F, 10.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 37).cuboid(5.0F, -12.0F, -10.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(34, 33).cuboid(1.0F, -12.0F, 7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(8, 33).cuboid(-3.0F, -12.0F, -7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 45).cuboid(0.0F, -12.0F, 12.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(40, 43).cuboid(-3.0F, -12.0F, 10.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(14, 43).cuboid(-2.0F, -12.0F, -10.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 42).cuboid(1.0F, -12.0F, -8.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData layer_2 = details.addChild("layer_2", ModelPartBuilder.create().uv(26, 32).cuboid(7.0F, -14.0F, -7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(7.0F, -14.0F, 7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(12, 15).cuboid(-9.0F, -14.0F, 7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(12, 10).cuboid(-9.0F, -14.0F, -7.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = holy_cloud.addChild("head", ModelPartBuilder.create().uv(52, 32).cuboid(-7.0F, -14.0F, -20.0F, 14.0F, 9.0F, 10.0F, new Dilation(0.0F))
				.uv(0, 14).cuboid(-2.0F, -9.0F, -22.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(2, 80).cuboid(-6.0F, -9.0F, -21.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 80).cuboid(3.0F, -9.0F, -21.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = holy_cloud.addChild("tail", ModelPartBuilder.create().uv(48, 58).cuboid(-4.0F, -8.0F, 14.0F, 8.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail_details = tail.addChild("tail_details", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData up_details = tail_details.addChild("up_details", ModelPartBuilder.create().uv(0, 4).cuboid(-2.0F, -9.0F, 14.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 42).cuboid(2.0F, -8.0F, 16.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(8, 42).cuboid(-4.0F, -8.0F, 14.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 42).cuboid(-1.0F, -8.0F, 17.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(12, 15).cuboid(-3.0F, -8.0F, 16.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData down_details = tail_details.addChild("down_details", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -9.0F, 14.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 38).cuboid(2.0F, -8.0F, 16.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(8, 38).cuboid(-4.0F, -8.0F, 14.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(16, 20).cuboid(-1.0F, -8.0F, 17.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(14, 0).cuboid(-3.0F, -8.0F, 16.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		ModelPartData wall_details = tail_details.addChild("wall_details", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wall_left = wall_details.addChild("wall_left", ModelPartBuilder.create().uv(16, 0).cuboid(4.0F, -9.0F, 14.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(40, 39).cuboid(4.0F, -6.0F, 16.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wall_right = wall_details.addChild("wall_right", ModelPartBuilder.create().uv(0, 20).cuboid(4.0F, -7.0F, 14.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(8, 20).cuboid(4.0F, -8.0F, 14.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(14, 39).cuboid(4.0F, -6.0F, 16.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 0.0F, 0.0F));

		ModelPartData smoke = tail.addChild("smoke", ModelPartBuilder.create().uv(14, 6).cuboid(1.0F, -7.0F, 19.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(16, 35).cuboid(-1.0F, -6.0F, 19.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(42, 32).cuboid(1.0F, -6.0F, 21.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(16, 32).cuboid(-4.0F, -6.0F, 19.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(HolyCloudEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.HOLY_CLOUD_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.HOLY_CLOUD_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.HOLY_CLOUD_ATTACK, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 25.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		holy_cloud.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return holy_cloud;
	}
}