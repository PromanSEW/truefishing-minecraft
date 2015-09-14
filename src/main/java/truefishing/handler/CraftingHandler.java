package truefishing.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import truefishing.items.*;

public class CraftingHandler {
	
	/** Initialization */
	public static void init() {
		registerRecipes();
	}
	
	/** Register recipes */
	private static void registerRecipes() {
		int i;
		ItemStack fish = new ItemStack(Items.fish);
		ItemStack fishRaw = new ItemStack(Items.fishRaw);
		for(i=0; i < Fish.COUNT; i++) {
			fish.setItemDamage(i);
			fishRaw.setItemDamage(i);
			GameRegistry.addSmelting(fishRaw, fish, 0.1f);
		}
	}
}
