package banduty.bsroleplay.util;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(BsRolePlay.MOD_ID, name));
        }
    }
}
