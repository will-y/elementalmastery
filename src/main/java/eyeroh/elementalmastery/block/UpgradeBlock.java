package eyeroh.elementalmastery.block;

import eyeroh.elementalmastery.machine.miner.TileMiner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class UpgradeBlock extends Block {
	// opal 0
	// topaz 1
	// ruby 2
	// sapphire 3
	private int type;
	
	public UpgradeBlock(int type) {
		super(Block.Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.sound(SoundType.STONE)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE));
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (world.isRemote) {
            return ActionResultType.SUCCESS;
        }
        
        BlockPos minerPos = lookForMiner(pos, world);
        
        if (minerPos == null) {
        	return  ActionResultType.SUCCESS;
        } else {
        	TileEntity te = world.getTileEntity(minerPos);
        	if (te instanceof TileMiner) {
        		// player.openGui(ElementalMastery.instance, 0, world, minerPos.getX(), minerPos.getY(), minerPos.getZ());
        	} else {
        		return  ActionResultType.FAIL;
        	}
        }
        
        return  ActionResultType.SUCCESS;
    }
	
	private BlockPos lookForMiner(BlockPos pos, World world) {
		BlockPos temp = pos;
		temp = pos.add(1, 0, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(-1, 0, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 1, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, -1, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 0, 1);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 0, -1);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		return null;
	}
	
}
