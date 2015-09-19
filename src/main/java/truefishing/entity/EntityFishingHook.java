package truefishing.entity;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.world.World;
import truefishing.items.ItemBait;

public class EntityFishingHook extends EntityFishHook implements IEntityAdditionalSpawnData {
	
	private ItemBait bait;
	
	public EntityFishingHook(World world) { super(world); }

	public EntityFishingHook(World world, EntityPlayer player, ItemBait bait) {
		super(world, player);
		this.bait = bait;
	}
	
	public void onUpdate() {
		super.onUpdate();
	}
	
	public void writeSpawnData(ByteBuf data) {
		data.writeInt(field_146042_b != null ? field_146042_b.getEntityId() : 0);
	}
	
	public void readSpawnData(ByteBuf data) {
		field_146042_b = (EntityPlayer) worldObj.getEntityByID(data.readInt());
	}
}
