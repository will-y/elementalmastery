package eyeroh.elementalmastery.machine.capacitor;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.NetworkRegistry;

public class BlockCapacitorController extends Block {

	public static final DirectionProperty PROPERTY_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty PROPERTY_ACTIVE = BooleanProperty.create("active");
	
	public BlockCapacitorController() {
		super(Block.Properties.create(Material.ROCK)
				.hardnessAndResistance(3.0f, 5.0f)
				.sound(SoundType.STONE)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE));
		this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_FACING, Direction.NORTH).with(PROPERTY_ACTIVE, false));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PROPERTY_FACING, PROPERTY_ACTIVE);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {

		return new TileEntityCapacitorController();
	}
	
	private TileEntityCapacitorController getTE(World world, BlockPos pos) {
		return (TileEntityCapacitorController) world.getTileEntity(pos);
	}
	
	@Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		TileEntityCapacitorController tileEntity = getTE(world, pos);
		if (!world.isRemote) {

        	if (state.get(PROPERTY_ACTIVE)) {
        		if (!player.getHeldItem(hand).getItem().equals(ModTools.LINKER)) {

				}
			} else {
				int size = tileEntity.checkAllMultiBlocks(state, pos, 2);
				if (size > 0) {
					world.setBlockState(pos, state.with(PROPERTY_ACTIVE, true));
					TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.capacitor_formed", "Capacitor Multiblock Formed");
					component.getStyle().func_240723_c_(TextFormatting.BLUE);
					player.sendStatusMessage(component, true);
				} else {
					TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.capacitor_formed", "Invalid Capacitor Multiblock");
					component.getStyle().func_240723_c_(TextFormatting.RED);
					player.sendStatusMessage(component, true);
				}
			}
        	openGui(tileEntity);
        }

        return ActionResultType.SUCCESS;
    }

	@OnlyIn(Dist.CLIENT)
	private void openGui(TileEntityCapacitorController tileEntity) {
		Minecraft.getInstance().displayGuiScreen(new ScreenCapacitor(tileEntity));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext blockItemUseContext) {
		return this.getDefaultState().with(PROPERTY_FACING, blockItemUseContext.getPlacementHorizontalFacing().getOpposite());
	}
}
