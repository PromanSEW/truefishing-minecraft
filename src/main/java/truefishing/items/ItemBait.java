package truefishing.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import truefishing.TrueFishing;

public class ItemBait extends BaseItem {
	
	public static final int COUNT = 7;
	
	@SideOnly(Side.CLIENT)
	private IIcon icons[];
	
	public ItemBait() {
		super("bait");
		setHasSubtypes(true);
	}
	
	public int getMetadata(int meta) { return meta; }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
		if(meta > COUNT-1) meta = 0;
        return icons[meta];
    }
	
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
		for(int i=0; i < COUNT; ++i) {
			icons[i] = reg.registerIcon(TrueFishing.RES_PREFIX + "baits/" + getUnwrappedName() + "_" + i);
		}
	}
}
