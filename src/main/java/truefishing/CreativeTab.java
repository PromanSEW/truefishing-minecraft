package truefishing;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import truefishing.items.TrueFishingItems;

public class CreativeTab extends CreativeTabs {
	public CreativeTab() { super(CreativeTabs.getNextID(), TrueFishing.MODID); }
	public Item getTabIconItem() { return TrueFishingItems.fishRaw; }
}
