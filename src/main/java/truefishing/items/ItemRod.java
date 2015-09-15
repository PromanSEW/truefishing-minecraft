package truefishing.items;

import net.minecraft.item.ItemFishingRod;
import truefishing.TrueFishing;

public class ItemRod extends ItemFishingRod {

	public ItemRod() {
		super();
		setUnlocalizedName("rod");
		setTextureName("minecraft:fishing_rod");
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	public int getItemEnchantability() { return 0; }
}
