package eyeroh.elementalmastery.machine.solar;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockSolar extends Block {
   private int type;
   private String name;

    public BlockSolar(String name, int type) {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
        this.type = type;
        this.name = name;
    }

//    @Nullable
//    @Override
//    public TileEntity createNewTileEntity(World worldIn, int meta) {
//        return new TileSolar(type, name);
//    }
}
