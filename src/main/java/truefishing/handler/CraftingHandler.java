package truefishing.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import truefishing.items.ItemFish;
import truefishing.items.TrueFishingItems;

public class CraftingHandler {
	
	/** Initialization */
	public static void init() {
		registerCraftingRecipes();
		registerSmeltingRecipes();
	}
	
	/** Register crafting recipes */
	private static void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.line), "###", "# #", "###", '#', Items.string);
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.rod), "#", "#", "#", '#', Items.stick);
	}
	
	/** Register smelting recipes */
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
