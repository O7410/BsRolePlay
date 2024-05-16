package banduty.bsroleplay.block.entity;
import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlock;
import banduty.bsroleplay.block.entity.coins.AmethystCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.CopperCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.NetheriteCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.AmethystCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.CopperCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.GoldCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.NetheriteCoinStackBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<TinyBandutyBlockEntity> TINY_BANDUTY_BLOCK_ENTITY;
    public static BlockEntityType<CopperCoinBlockEntity> COPPER_COIN_BLOCK_ENTITY;
    public static BlockEntityType<GoldCoinBlockEntity> GOLD_COIN_BLOCK_ENTITY;
    public static BlockEntityType<AmethystCoinBlockEntity> AMETHYST_COIN_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteCoinBlockEntity> NETHERITE_COIN_BLOCK_ENTITY;
    public static BlockEntityType<CopperCoinStackBlockEntity> COPPER_COIN_STACK_BLOCK_ENTITY;
    public static BlockEntityType<GoldCoinStackBlockEntity> GOLD_COIN_STACK_BLOCK_ENTITY;
    public static BlockEntityType<AmethystCoinStackBlockEntity> AMETHYST_COIN_STACK_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteCoinStackBlockEntity> NETHERITE_COIN_STACK_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        TINY_BANDUTY_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "tiny_banduty_block_entity"),
                FabricBlockEntityTypeBuilder.create(TinyBandutyBlockEntity::new,
                        ModBlock.TINY_BANDUTY).build());

        COPPER_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "copper_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(CopperCoinBlockEntity::new,
                        ModBlock.COPPER_COIN).build());

        GOLD_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "gold_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(GoldCoinBlockEntity::new,
                        ModBlock.GOLD_COIN).build());

        AMETHYST_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "amethyst_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(AmethystCoinBlockEntity::new,
                        ModBlock.AMETHYST_COIN).build());

        NETHERITE_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "netherite_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(NetheriteCoinBlockEntity::new,
                        ModBlock.NETHERITE_COIN).build());

        COPPER_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "copper_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(CopperCoinStackBlockEntity::new,
                        ModBlock.COPPER_COIN_STACK).build());

        GOLD_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "gold_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(GoldCoinStackBlockEntity::new,
                        ModBlock.GOLD_COIN_STACK).build());

        AMETHYST_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "amethyst_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(AmethystCoinStackBlockEntity::new,
                        ModBlock.AMETHYST_COIN_STACK).build());

        NETHERITE_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "netherite_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(NetheriteCoinStackBlockEntity::new,
                        ModBlock.NETHERITE_COIN_STACK).build());
    }
}