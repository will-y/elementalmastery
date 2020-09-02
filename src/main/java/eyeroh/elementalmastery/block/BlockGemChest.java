package eyeroh.elementalmastery.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockGemChest extends Block {
    public static final DirectionProperty PROPERTY_FACING = BlockStateProperties.FACING;
    public static final BooleanProperty PROPERTY_OPEN = BlockStateProperties.OPEN;

    public BlockGemChest() {
        super(Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f));
        // this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_FACING, Direction.NORTH).with(PROPERTY_OPEN, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileGemChest();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult trace) {
        world.playSound(player, pos, SoundEvents.BLOCK_BARREL_OPEN, SoundCategory.BLOCKS, 1, 1);
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof TileGemChest) {
                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("screen.elementalmastery.chestopal");
                    }

                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new ContainerGemChest(i, world, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(PROPERTY_FACING, rot.rotate(state.get(PROPERTY_FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(PROPERTY_FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        TileGemChest tile = (TileGemChest) worldIn.getTileEntity(pos);
        tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent((itemHandler) -> {
            List<ItemStack> stacks = new ArrayList<>();
             for (int i = 0; i < itemHandler.getSlots(); i++) {
                 stacks.add(itemHandler.getStackInSlot(i));
             }
             NonNullList<ItemStack> list = NonNullList.from(ItemStack.EMPTY, stacks.toArray(new ItemStack[0]));
             InventoryHelper.dropItems(worldIn, pos, list);
        });
    }
}
