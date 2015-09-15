package truefishing.items;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import truefishing.TrueFishing;

public class BaseItem extends Item {
	
	public BaseItem(String name) {
		setUnlocalizedName(name);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	/** @return <s>item.</s>unlocalizedName */
	public String getUnwrappedName() { return getUnlocalizedName().substring(5); }
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
	    itemIcon = iconRegister.registerIcon("item." + TrueFishing.RES_PREFIX + getUnwrappedName());
	}
}
