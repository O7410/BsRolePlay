package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.screen.WalletScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class Wallet extends Item implements DyeableItem {
    private static final int DEFAULT_CURRENCY = 0;
    public Wallet(Settings settings) {
        super(settings);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(COLOR_KEY);
        }
        return DEFAULT_COLOR;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack walletItemStack = user.getStackInHand(hand);
        int colorKey = getColor(walletItemStack);
        int amountCurrency = getCurrencyFromNbt(walletItemStack);
        Inventory walletInventory = getInventoryFromNbt();
        if(hand == Hand.OFF_HAND || user.isSneaking()) return TypedActionResult.fail(user.getStackInHand(hand));
        if(!world.isClient) {
            user.openHandledScreen(new ExtendedScreenHandlerFactory() {

                @Override
                public @NotNull ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                    return new WalletScreenHandler(syncId, playerInventory, walletInventory, walletItemStack, colorKey, amountCurrency);
                }

                @Override
                public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
                    buf.writeItemStack(walletItemStack);
                    buf.writeInt(colorKey);
                    buf.writeInt(amountCurrency);
                }

                @Override
                public Text getDisplayName() {
                    return Text.literal("");
                }
            });
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public static Inventory getInventoryFromNbt() {
        return new SimpleInventory(1);
    }

    public static int getCurrencyFromNbt(ItemStack walletItemStack) {
        if (walletItemStack.getNbt() != null && walletItemStack.getNbt().contains("amountCurrency", NbtElement.INT_TYPE)) {
            return walletItemStack.getOrCreateNbt().getInt("amountCurrency");
        }
        return DEFAULT_CURRENCY;
    }

    public static void writeCurrencyToNbt(ItemStack walletItemStack, int amountCurrency) {
        walletItemStack.getOrCreateNbt().putInt("amountCurrency", amountCurrency);
    }
}