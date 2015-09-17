package truefishing.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import truefishing.TrueFishing;

public class ItemPasta extends ItemFood {
	
	public ItemPasta() {
		super(3, false);
		setUnlocalizedName("pasta");
		setCreativeTab(TrueFishing.creativeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		itemIcon = reg.registerIcon(TrueFishing.RES_PREFIX + "pasta");
	}
}
