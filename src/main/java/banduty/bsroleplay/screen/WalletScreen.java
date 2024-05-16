package banduty.bsroleplay.screen;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.TextureWidget;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class WalletScreen extends HandledScreen<WalletScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/wallet_gui.png");
    private static final Identifier TEXTURE_OVERLAY = new Identifier(BsRolePlay.MOD_ID, "textures/gui/wallet_gui_overlay.png");
    private static final Identifier CONFIRM = new Identifier(BsRolePlay.MOD_ID, "textures/gui/confirm.png");
    private static final Identifier BRONZE_COIN = new Identifier(BsRolePlay.MOD_ID, "textures/item/copper_coin.png");
    private static final Identifier GOLD_COIN = new Identifier(BsRolePlay.MOD_ID, "textures/item/gold_coin.png");
    private static final Identifier AMETHYST_COIN = new Identifier(BsRolePlay.MOD_ID, "textures/item/amethyst_coin.png");
    private static final Identifier NETHERITE_COIN = new Identifier(BsRolePlay.MOD_ID, "textures/item/netherite_coin.png");

    public WalletScreen(WalletScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected int backgroundWidth = 214;
    protected int backgroundHeight = 166;

    @Override
    protected void init() {
        PlayerEntity playerEntity = MinecraftClient.getInstance().player;
        super.init();
        playerInventoryTitleY = 1000;
        titleY = 1000;
        if (playerEntity == null) return;
        playerEntity.playSound(ModSounds.WALLET_CLOSE, 1f, 1f);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        ButtonWidget confirmWidget = ButtonWidget.builder(Text.literal(""), button -> handler.addAmountCurrency(0))
                .dimensions(x+64, y+45, 18, 18)
                .build();
        TextureWidget checkWidget = TextureWidget.create(x+64, y+45, 18, 18, CONFIRM, 18, 18);

        ButtonWidget getBronceWidget = ButtonWidget.builder(Text.literal(""), button -> handler.removeAmountCurrencyCopper())
                .dimensions(x+134, y+27, 18, 18)
                .build();
        TextureWidget bronceWidget = TextureWidget.create(x+135, y+28, 16, 16, BRONZE_COIN, 16, 16);

        ButtonWidget getGoldWidget = ButtonWidget.builder(Text.literal(""), button -> handler.removeAmountCurrencyGold())
                .dimensions(x+152, y+27, 18, 18)
                .build();
        TextureWidget goldWidget = TextureWidget.create(x+153, y+28, 16, 16, GOLD_COIN, 16, 16);

        ButtonWidget getAmethystWidget = ButtonWidget.builder(Text.literal(""), button -> handler.removeAmountCurrencyAmethyst())
                .dimensions(x+134, y+45, 18, 18)
                .build();
        TextureWidget amethystWidget = TextureWidget.create(x+135, y+46, 16, 16, AMETHYST_COIN, 16, 16);

        ButtonWidget getNetheriteWidget = ButtonWidget.builder(Text.literal(""), button -> handler.removeAmountCurrencyNetherite())
                .dimensions(x+152, y+45, 18, 18)
                .build();
        TextureWidget netheriteWidget = TextureWidget.create(x+153, y+46, 16, 16, NETHERITE_COIN, 16, 16);

        addDrawableChild(confirmWidget);
        addDrawableChild(checkWidget);

        addDrawableChild(getBronceWidget);
        addDrawableChild(bronceWidget);

        addDrawableChild(getGoldWidget);
        addDrawableChild(goldWidget);

        addDrawableChild(getAmethystWidget);
        addDrawableChild(amethystWidget);

        addDrawableChild(getNetheriteWidget);
        addDrawableChild(netheriteWidget);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE_OVERLAY, x, y, 0, 0, backgroundWidth, backgroundHeight);
        Color color = new Color(handler.getColorKey());
        var r = color.getRed();
        var g = color.getGreen();
        var b = color.getBlue();
        context.setShaderColor((float) r / 375, (float) g / 375, (float) b / 375, 0);
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawCenteredTextWithShadow(textRenderer, Text.literal(handler.getAmountCurrency() + " RP"), x+152, y+12, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, Text.literal("Wallet"), x+62, y+10, 0xffffff);
        context.drawTexture(CONFIRM, x+64, y+45, 0, 0, 18, 18);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}