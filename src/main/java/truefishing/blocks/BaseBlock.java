package truefishing.blocks;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import truefishing.TrueFishing;

public class BaseBlock extends Block {
	
	protected BaseBlock(String name, Material material) {
		super(material);
		setBlockName(name);
		setBlockTextureName(TrueFishing.RES_PREFIX + name);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
	    blockIcon = iconRegister.registerIcon(getUnlocalizedName());
	}
}
