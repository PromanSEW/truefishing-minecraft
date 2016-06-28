package truefishing.blocks;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import truefishing.items.TrueFishingItems;

public class CornCrop extends BaseCrop {
	
	protected CornCrop() { super("corn"); }
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> items = super.getDrops(world, x, y, z, metadata, fortune);
		if (metadata == 1) items.add(new ItemStack(TrueFishingItems.bait, world.rand.nextInt(3) + 1 + fortune, 8));
		return items;
	}
}
