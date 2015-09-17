package truefishing.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import truefishing.TrueFishing;

public class BaseItem extends Item {
	
	public BaseItem(String name) {
		setUnlocalizedName(name);
		setCreativeTab(TrueFishing.creativeTab);
	}
	
	/** @return <s>item.</s>unlocalizedName */
	public String getUnwrappedName() { return getUnlocalizedName().substring(5); }
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
	    itemIcon = iconRegister.registerIcon(TrueFishing.RES_PREFIX + getUnwrappedName());
	}
}
