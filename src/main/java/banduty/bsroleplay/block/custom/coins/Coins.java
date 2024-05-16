package banduty.bsroleplay.block.custom.coins;

import banduty.bsroleplay.block.ModBlock;
import banduty.bsroleplay.block.entity.coins.AmethystCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.CopperCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.NetheriteCoinBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Coins extends BlockWithEntity {
    public static final MapCodec<Coins> CODEC = Coins.createCodec(Coins::new);
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public Coins(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
    protected static final VoxelShape SHAPE;
    public static final DirectionProperty FACING;

    static {
        SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 1.0, 11.0);
        FACING = HorizontalFacingBlock.FACING;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        if (state.getBlock() == ModBlock.COPPER_COIN) return new CopperCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlock.GOLD_COIN) return new GoldCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlock.AMETHYST_COIN) return new AmethystCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlock.NETHERITE_COIN) return new NetheriteCoinBlockEntity(pos, state);
        return new CopperCoinBlockEntity(pos, state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
