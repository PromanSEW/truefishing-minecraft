package truefishing.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import truefishing.items.ItemFish;

public class EntityFish extends EntityItem {
	
	private int weight;

	public EntityFish(World world, double x, double z, double y, ItemStack stack, int weight) {
		super(world, x, z, y, stack);
		this.weight = weight;
	}

	public void onCollideWithPlayer(EntityPlayer player) {
		if (!worldObj.isRemote) {
			if (delayBeforeCanPickup > 0) return;
			ItemStack stack = this.getEntityItem();
			if (stack.getItem() instanceof ItemFish) {
				ItemFish item = (ItemFish) stack.getItem();
				//item.setWeight(weight, stack);
			}
			int i = stack.stackSize;
			if (this.delayBeforeCanPickup <= 0 && (i <= 0 || player.inventory.addItemStackToInventory(stack))) {
				playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				player.onItemPickup(this, i);
				if (stack.stackSize <= 0) this.setDead();
			}
		}
	}
}
