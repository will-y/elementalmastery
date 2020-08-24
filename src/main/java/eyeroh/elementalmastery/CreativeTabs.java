package eyeroh.elementalmastery;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabs {

    public static final ItemGroup tabGemBlocks = (new ItemGroup("tabGemBlocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModMachines.collectorSpeed);
        }
    });

    public static final ItemGroup tabGemItems = (new ItemGroup("tabGemItems") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GEM_OPAL.get());
        }

    });

    public static final ItemGroup tabGemTools = (new ItemGroup("tabGemTools") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModTools.OPAL_PICKAXE.get());
        }

    });
}
