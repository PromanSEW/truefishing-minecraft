package truefishing.items;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import truefishing.TrueFishing;
import truefishing.inventory.ContainerItem;

public class ItemStore extends BaseItem {

	public ItemStore(String name) {
		super(name);
		maxStackSize = 1;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean isCurrentItem) {
		if(!world.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if(FMLClientHandler.instance().getClient().inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_I) && 
					player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemStore) {
				player.openGui(TrueFishing.instance, 1, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
			if(player.openContainer != null && player.openContainer instanceof ContainerItem) {
				ContainerItem item = (ContainerItem) player.openContainer;
				if(item.needsUpdate) { item.writeToNBT(); item.needsUpdate = false; }
			}
		}
	}
}
