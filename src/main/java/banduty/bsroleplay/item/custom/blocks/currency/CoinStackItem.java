package banduty.bsroleplay.item.custom.blocks.currency;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoinStackItem extends BlockItem {

    public CoinStackItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.currency.showCoinPrice) {
            if (stack.getItem() == ModItems.COPPER_COIN_STACK) tooltip.add(Text.literal("9 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.GOLD_COIN_STACK) tooltip.add(Text.literal("90 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.AMETHYST_COIN_STACK) tooltip.add(Text.literal("900 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.NETHERITE_COIN_STACK) tooltip.add(Text.literal("9000 RP").formatted(Formatting.AQUA));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
