package truefishing.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import truefishing.items.TrueFishingItems;

public class DropHandler {
	
	@SubscribeEvent
	public void onBlockDropItems(HarvestDropsEvent event) {
		// Drop worm from dirt and grass with 10% chance at Y > 32
		if((event.block == Blocks.dirt && event.y > 32) || event.block == Blocks.grass) {
			if(Math.random() < 0.1) event.drops.add(new ItemStack(TrueFishingItems.bait, 1, 1));
		}
	}
}
