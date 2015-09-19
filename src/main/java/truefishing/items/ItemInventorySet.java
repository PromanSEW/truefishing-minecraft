package truefishing.items;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import truefishing.TrueFishing;
import truefishing.inventory.ContainerItem;
import truefishing.entity.EntityFishingHook;

public class ItemInventorySet extends ItemFishingRod {

	public ItemInventorySet() {
		super();
		setUnlocalizedName("invset");
		setTextureName("minecraft:fishing_rod");
		setMaxDamage(0);
	}
	
	public int getItemEnchantability() { return 0; }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.fishEntity != null) {
			player.fishEntity.func_146034_e();
			player.swingItem();
		} else {
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.isRemote) world.spawnEntityInWorld(new EntityFishingHook(world, player, null));
            player.swingItem();
		} return stack;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean isCurrentItem) {
		if(!world.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if(FMLClientHandler.instance().getClient().inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_I) && 
					player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemInventorySet) {
				player.openGui(TrueFishing.instance, 1, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
			if(player.openContainer != null && player.openContainer instanceof ContainerItem) {
				ContainerItem item = (ContainerItem) player.openContainer;
				if(item.needsUpdate) { item.writeToNBT(); item.needsUpdate = false; }
			}
		}
	}
}
