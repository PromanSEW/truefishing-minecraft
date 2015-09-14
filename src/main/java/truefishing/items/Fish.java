package truefishing.items;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import truefishing.TrueFishing;

public class Fish extends ItemFishFood {
	
	private boolean raw;
	public static final int COUNT = 3;
	@SideOnly(Side.CLIENT)
	private static IIcon[] icons;
	
	public Fish(boolean raw) {
		super(raw);
		this.raw = raw;
		setUnlocalizedName("fish");
		setTextureName("fish" + (raw ? "Raw" : "") + ".0");
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	public int getMetadata(int damage) { return damage; }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage) { return icons[damage]; }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack) { return getIconFromDamage(stack.getItemDamage()); }
	
	public String getUnwrappedUnlocalizedName(String name) {
	    return name.substring(name.indexOf(".") + 1);
	}
	
	public String getUnlocalizedName() {
		return TrueFishing.RES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("item." + getUnlocalizedName() + ".0");
		icons = new IIcon[COUNT];
		for(int i=0; i < COUNT; i++) 
			icons[i] = iconRegister.registerIcon("item." + getUnlocalizedName() + "." + i);
	}
	
	public boolean isRaw() { return raw; }
}
