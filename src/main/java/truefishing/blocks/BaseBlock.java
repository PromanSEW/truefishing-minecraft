package truefishing.blocks;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import truefishing.TrueFishing;

public class BaseBlock extends Block {
	
	protected BaseBlock(Material material) {
		super(material);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
		
	public String getUnwrappedUnlocalizedName(String name) {
	    return name.substring(name.indexOf(".") + 1);
	}
	
	public String getUnlocalizedName() {
		return TrueFishing.RES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
	}
		
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
	    blockIcon = iconRegister.registerIcon(TrueFishing.RES_PREFIX + 
	    		getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}
