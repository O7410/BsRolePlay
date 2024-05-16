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

public class RPCoinItem extends BlockItem {

    public RPCoinItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.currency.showCoinPrice) {
            if (stack.getItem() == ModItems.COPPER_COIN) tooltip.add(Text.literal("1 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.GOLD_COIN) tooltip.add(Text.literal("10 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.AMETHYST_COIN) tooltip.add(Text.literal("100 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.NETHERITE_COIN) tooltip.add(Text.literal("1000 RP").formatted(Formatting.AQUA));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
