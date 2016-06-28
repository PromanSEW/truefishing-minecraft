package truefishing.entity.projectile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.world.World;
import truefishing.items.ItemBait;

public class EntityFishingHook extends EntityFishHook {
	
	private ItemBait bait;

	public EntityFishingHook(World world, EntityPlayer player, ItemBait bait) {
		super(world, player);
		this.bait = bait;
	}
	
	public void onUpdate() {
		super.onUpdate();
	}
}
