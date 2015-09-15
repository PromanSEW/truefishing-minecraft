package truefishing.items;

import java.util.List;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
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
		setUnlocalizedName("fish" + (raw ? "Raw" : ""));
		setHasSubtypes(true);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	public int getMetadata(int meta) { return meta; }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		if(meta > COUNT-1) meta = 0;
		return icons[meta];
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack) { return getIconFromDamage(stack.getItemDamage()); }
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i=0; i < COUNT; i++) list.add(new ItemStack(item, 1, i));
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icons = new IIcon[COUNT];
		for(int i=0; i < COUNT; i++) 
			icons[i] = reg.registerIcon(TrueFishing.RES_PREFIX + getUnlocalizedName()); // + "_" + i);
	}
	
	public boolean isRaw() { return raw; }
}
