package truefishing.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import truefishing.TrueFishing;

public class ItemBait extends InventoryItem {
	
	public static final int COUNT = 10;
	
	@SideOnly(Side.CLIENT)
	private IIcon icons[];
	
	public ItemBait() {
		super("bait");
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int meta) { return meta; }
	
	public int getMaxItemUseDuration(ItemStack stack) {
		switch(stack.getItemDamage()) {
		case 7: // Peas
		case 8: // Corn
		case 9: // Cheese
			return 32;
		} return 0;
	}
	
	public EnumAction getItemUseAction(ItemStack stack) {
		switch(stack.getItemDamage()) {
		case 7: // Peas
		case 8: // Corn
		case 9: // Cheese
			return EnumAction.eat;
		} return EnumAction.none;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		switch(stack.getItemDamage()) {
		case 7: // Peas
		case 8: // Corn
		case 9: // Cheese
			if (player.canEat(false)) player.setItemInUse(stack, getMaxItemUseDuration(stack));
		} return stack;
	}
	
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		switch(stack.getItemDamage()) {
		case 7: return onFoodEaten(2, 0.5f, stack, world, player); // Peas
		case 8: return onFoodEaten(1, 0.2f, stack, world, player); // Corn
		case 9: return onFoodEaten(3, 0.8f, stack, world, player); // Cheese
		} return stack;
	}
	
	private ItemStack onFoodEaten(int heal, float saturation, ItemStack stack, World world, EntityPlayer player) {
		--stack.stackSize;
        player.getFoodStats().addStats(heal, saturation);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) { if (meta > COUNT-1) meta = 0; return icons[meta]; }
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i=0; i < COUNT; i++) list.add(new ItemStack(item, 1, i));
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icons = new IIcon[COUNT];
		for (int i=0; i < COUNT; ++i) {
			icons[i] = reg.registerIcon(TrueFishing.RES_PREFIX + "baits/" + getUnwrappedName() + "_" + i);
		}
	}
}
