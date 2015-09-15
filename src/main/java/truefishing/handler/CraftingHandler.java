package truefishing.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import truefishing.items.*;

public class CraftingHandler {
	
	/** Initialization */
	public static void init() {
		registerCraftingRecipes();
		registerSmeltingRecipes();
	}
	
	/** Register recipes */
	private static void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.ud), "#", "#", "#", '#', Items.stick);
	}
	
	/** Register recipes */
	private static void registerSmeltingRecipes() {
		int i;
		ItemStack input, output;
		// Smelting fishes;
		input = new ItemStack(TrueFishingItems.fishRaw);
		output = new ItemStack(TrueFishingItems.fish);
		for(i=0; i < ItemFish.COUNT; i++) {
			input.setItemDamage(i);
			output.setItemDamage(i);
			GameRegistry.addSmelting(input, output, 0.1f);
		}
	}
}
