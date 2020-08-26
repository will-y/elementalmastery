package eyeroh.elementalmastery.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GemBlock extends Block {
	public GemBlock() {
		super(Block.Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.sound(SoundType.STONE)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
				.func_235861_h_());
	}
}
