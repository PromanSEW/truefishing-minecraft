package truefishing;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public CreativeTab() { super(CreativeTabs.getNextID(), TrueFishing.MODID); }
	
	public Item getTabIconItem() {
		// TODO: Иконка для вкладки
		return null;
	}

}
