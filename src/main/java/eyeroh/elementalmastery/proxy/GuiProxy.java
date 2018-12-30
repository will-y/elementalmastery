package eyeroh.elementalmastery.proxy;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.gui.CapacitorGui;
import eyeroh.elementalmastery.gui.CollectorGui;
import eyeroh.elementalmastery.gui.GeneratorGui;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import eyeroh.elementalmastery.machine.collector.CollectorHealContainer;
import eyeroh.elementalmastery.machine.collector.CollectorStrengthContainer;
import eyeroh.elementalmastery.machine.collector.TileCollector;
import eyeroh.elementalmastery.machine.collector.TileCollectorHeal;
import eyeroh.elementalmastery.machine.collector.TileCollectorStrength;
import eyeroh.elementalmastery.machine.generator.GeneratorContainer;
import eyeroh.elementalmastery.machine.generator.GeneratorTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	System.out.println("server?");
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof CollectorBasicTileEntity) {
            //return new CollectorContainer(player.inventory, player.inventory, (CollectorBasicTileEntity) te);
        } else if (te instanceof GeneratorTileEntity) {
        	return new GeneratorContainer(player.inventory, player.inventory, (GeneratorTileEntity) te);
        } else if (te instanceof TileCollector) {
        	if(te instanceof TileCollectorStrength) {
        		return new CollectorStrengthContainer(player.inventory, player.inventory, (TileCollector) te);
        	} else if (te instanceof TileCollectorHeal) {
        		return new CollectorHealContainer(player.inventory, player.inventory, (TileCollector)te);
        	}
        	return new CollectorContainer(player.inventory, player.inventory, (TileCollector) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	System.out.println("probably not");
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof CollectorBasicTileEntity) {
        	System.out.println("false trigger");
            CollectorBasicTileEntity containerTileEntity = (CollectorBasicTileEntity) te;
            //return new BasicCollectorGui(containerTileEntity, new CollectorContainer(player.inventory, player.inventory, containerTileEntity));
        } else if (te instanceof GeneratorTileEntity) {
        	GeneratorTileEntity generatorTileEntity = (GeneratorTileEntity) te;
        	GeneratorContainer generatorContainer = new GeneratorContainer(player.inventory, player.inventory, generatorTileEntity);
        	System.out.println("generator");
        	switch(generatorTileEntity.getType()) {
        	case 0:
        		return new GeneratorGui(generatorTileEntity, generatorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatoropal.png"));
        	case 1:
        		return new GeneratorGui(generatorTileEntity, generatorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatortopaz.png"));
        	case 2:
        		return new GeneratorGui(generatorTileEntity, generatorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatorruby.png"));
        	case 3:
        		return new GeneratorGui(generatorTileEntity, generatorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatorsapphire.png"));
        	default:
        		return new GeneratorGui(generatorTileEntity, generatorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatoropal.png"));
        	}
        } else if (te instanceof TileEntityCapacitorController) {
        	TileEntityCapacitorController capacitorControllerTileEntity = (TileEntityCapacitorController) te;
        	return new CapacitorGui(capacitorControllerTileEntity);
        } else if (te instanceof  TileCollector) {
        	TileCollector tileCollector = (TileCollector) te;
        	CollectorContainer collectorContainer;
        	if(te instanceof TileCollectorStrength) {
        		collectorContainer = new CollectorStrengthContainer(player.inventory, player.inventory, (TileCollectorStrength)tileCollector);
        	} else if(te instanceof TileCollectorHeal) {
        		collectorContainer = new CollectorHealContainer(player.inventory, player.inventory, (TileCollectorHeal)tileCollector);
        	} else {
        		collectorContainer = new CollectorContainer(player.inventory, player.inventory, tileCollector);
        	}
        	return new CollectorGui(tileCollector, collectorContainer, new ResourceLocation(ElementalMastery.MODID, "textures/gui/" + tileCollector.getFileName() + ".png"));
        }
        return null;
    }
}