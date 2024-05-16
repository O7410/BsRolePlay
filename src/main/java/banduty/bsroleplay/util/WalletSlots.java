package banduty.bsroleplay.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.slot.Slot;

public class WalletSlots extends Slot {
    private final TagKey<Item> allowedTagItems;
    private final Item allowedItems;
    public WalletSlots(Inventory inventory, int index, int x, int y, TagKey<Item> allowedTagItems) {
        super(inventory, index, x, y);
        this.allowedTagItems = allowedTagItems;
        this.allowedItems = null;
    }

    public WalletSlots(Inventory inventory, int index, int x, int y, Item allowedItems) {
        super(inventory, index, x, y);
        this.allowedItems = allowedItems;
        this.allowedTagItems = null;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (allowedTagItems != null) return stack.isIn(allowedTagItems);
        if (allowedItems != null) return stack.isOf(allowedItems);
        return false;
    }
}