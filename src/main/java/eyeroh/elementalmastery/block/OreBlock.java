package eyeroh.elementalmastery.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class OreBlock extends Block {
	public OreBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 10.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
//		setUnlocalizedName(ElementalMastery.MODID + "." + name);
//		setRegistryName(name);
	}
	
	@Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        Random rand = new Random();
        return rand.nextInt(3) + 2;
    }
}
