package banduty.bsroleplay.screen;

import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.item.Wallet;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.ModTags;
import banduty.bsroleplay.util.WalletSlots;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class WalletScreenHandler extends ScreenHandler {
    private final Inventory walletInventory ;
    private final ItemStack walletItemStack;
    private final int colorKey;
    private static int amountCurrency;
    static int maxCoins = 9999;


    PlayerEntity player = new PlayerEntity() {
        @Override
        public boolean isSpectator() {
            return false;
        }

        @Override
        public boolean isCreative() {
            return true;
        }
    };

    public WalletScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, new SimpleInventory(1), buf.readItemStack(), buf.readInt(), buf.readInt());
    }

    public WalletScreenHandler(int syncId, PlayerInventory playerInventory, Inventory walletInventory, ItemStack walletItemStack, Integer colorKey, Integer amountCurrency) {
        super(ModScreenHandlers.WALLET_SCREEN_HANDLER, syncId);
        checkSize(walletInventory, 1);
        this.walletInventory = walletInventory;
        this.walletItemStack = walletItemStack;
        this.colorKey = colorKey;
        WalletScreenHandler.amountCurrency = amountCurrency;
        walletInventory.onOpen(playerInventory.player);

        this.addSlot(new WalletSlots(walletInventory, 0, 24, 46, ModTags.Items.COINS));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public int getColorKey() {
        return colorKey;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.dropInventory(player, walletInventory);
        Wallet.writeCurrencyToNbt(walletItemStack, amountCurrency);
        if (MinecraftClient.getInstance().player == null) return;
        MinecraftClient.getInstance().player.playSound(ModSounds.WALLET_CLOSE, 1f, 1f);
    }

    public int getAmountCurrency() {
        return Math.min(maxCoins, amountCurrency);
    }

    public void addAmountCurrency(int invSlot) {
        int copperStackCoins = maxCoins - 9;
        int goldCoins = maxCoins - 10;
        int goldStackCoins = maxCoins - 90;
        int amethystCoins = maxCoins - 100;
        int amethystStackCoins = maxCoins - 900;
        int netheriteCoins = maxCoins - 1000;
        int netheriteStackCoins = maxCoins - 9000;
        Slot slot = this.slots.get(invSlot);
        if (amountCurrency < maxCoins) {
            if (slot.getStack().itemMatches(ModItems.COPPER_COIN.getRegistryEntry())) {
                amountCurrency += 1;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.COPPER_COIN_STACK.getRegistryEntry()) && amountCurrency <= copperStackCoins) {
                amountCurrency += 9;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.GOLD_COIN.getRegistryEntry()) && amountCurrency <= goldCoins) {
                amountCurrency += 10;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.GOLD_COIN_STACK.getRegistryEntry()) && amountCurrency <= goldStackCoins) {
                amountCurrency += 90;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.AMETHYST_COIN.getRegistryEntry()) && amountCurrency <= amethystCoins) {
                amountCurrency += 100;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.AMETHYST_COIN_STACK.getRegistryEntry()) && amountCurrency <= amethystStackCoins) {
                amountCurrency += 900;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.NETHERITE_COIN.getRegistryEntry()) && amountCurrency <= netheriteCoins) {
                amountCurrency += 1000;
                walletInventory.removeStack(0, 1);
            }
            if (slot.getStack().itemMatches(ModItems.NETHERITE_COIN_STACK.getRegistryEntry()) && amountCurrency <= netheriteStackCoins) {
                amountCurrency += 9000;
                walletInventory.removeStack(0, 1);
            }
        }
    }

    public void removeAmountCurrencyCopper() {
        if (amountCurrency <= maxCoins) {
            if (amountCurrency >= 1) {
                amountCurrency -= 1;
                if (player == null) return;
                player.getInventory().offerOrDrop(ModItems.COPPER_COIN.getDefaultStack());
            }
        }
    }

    public void removeAmountCurrencyGold() {
        if (amountCurrency <= maxCoins) {
            if (amountCurrency >= 10) {
                amountCurrency -= 10;
                if (player == null) return;
                player.getInventory().offerOrDrop(ModItems.GOLD_COIN.getDefaultStack());
            }
        }
    }

    public void removeAmountCurrencyAmethyst() {
        if (amountCurrency <= maxCoins) {
            if (amountCurrency >= 100) {
                amountCurrency -= 100;
                if (player == null) return;
                player.getInventory().offerOrDrop(ModItems.AMETHYST_COIN.getDefaultStack());
            }
        }
    }

    public void removeAmountCurrencyNetherite() {
        if (amountCurrency <= maxCoins) {
            if (amountCurrency >= 1000) {
                amountCurrency -= 1000;
                if (player == null) return;
                player.getInventory().offerOrDrop(ModItems.NETHERITE_COIN.getDefaultStack());
            }
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.walletInventory.size()) {
                if (!this.insertItem(originalStack, this.walletInventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.walletInventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.walletInventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}