package truefishing.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import truefishing.TrueFishing;

public class ItemFish extends ItemFood {

	private boolean raw;
	private boolean poison = false;
	public static final int COUNT = 3;
	
	public ItemFish(boolean raw) {
		super(5, false);
		this.raw = raw;
		setUnlocalizedName("fish" + (raw ? "Raw" : ""));
		setHasSubtypes(true);
		setCreativeTab(TrueFishing.getCreativeTab());
	}
	
	/** @return Fish is raw or not */
	public boolean isRaw() { return raw; }
	
	/** @return Fish is poisonous or not */
	public boolean isPoison() { return poison; }
	
	/** Set poisonousness of fish */
	public void setPoison(boolean poison) { this.poison = poison; }
	
	public int getMetadata(int meta) { return meta; }
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i=0; i < COUNT; i++) list.add(new ItemStack(item, 1, i));
	}
	
	/** @return <s>item.</s>unlocalizedName */
	public String getUnwrappedName() { return getUnlocalizedName().substring(5); }
	
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
    public String getPotionEffect(ItemStack stack) { return null; }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		itemIcon = reg.registerIcon("minecraft:fish_cod_" + (raw ? "raw" : "cooked"));
	}
	
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!raw) super.onEaten(stack, world, player);
		return stack;
    }
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(poison) {
			player.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3));
            player.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
		}
    }
	
    public int getMaxItemUseDuration(ItemStack stack) { return raw ? 0 : 32; }
}
