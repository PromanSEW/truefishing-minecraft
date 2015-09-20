package truefishing.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import truefishing.TrueFishing;
import truefishing.blocks.BaseCrop;

public class BaseSeeds extends ItemSeeds {
	public BaseSeeds(String name, BaseCrop crop) {
		super(crop, Blocks.farmland);
		setUnlocalizedName("seeds." + name);
		setCreativeTab(TrueFishing.creativeTab);
	}
}
