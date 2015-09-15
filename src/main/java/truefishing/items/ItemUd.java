package truefishing.items;

import net.minecraft.item.ItemFishingRod;
import truefishing.TrueFishing;

public class ItemUd extends ItemFishingRod {

	public ItemUd() {
		super();
		setUnlocalizedName("ud");
		setTextureName("minecraft:fishing_rod");
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	public int getItemEnchantability() { return 0; }
}
