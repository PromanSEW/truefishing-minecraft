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
		ItemStack input, output;
		// Flour
		GameRegistry.addShapelessRecipe(new ItemStack(TrueFishingItems.flour, 2), Items.wheat);
		// Dough
		output = new ItemStack(TrueFishingItems.bait, 8, 2);
		GameRegistry.addShapelessRecipe(output, 
				new ItemStack(Items.milk_bucket.setContainerItem(Items.bucket)), 
				Items.egg, TrueFishingItems.flour, TrueFishingItems.flour);
		// Live bait
		input = new ItemStack(TrueFishingItems.fishRaw);
		output = new ItemStack(TrueFishingItems.bait, 1, 3);
		for(int i=0; i < ItemFish.COUNT; i++) {
			input.setItemDamage(i);
			GameRegistry.addShapelessRecipe(output, input);
		}
		// Meat
		output = new ItemStack(TrueFishingItems.bait, 8, 4);
		GameRegistry.addShapelessRecipe(output, Items.beef);
		GameRegistry.addShapelessRecipe(output, Items.porkchop);
		// Pasta
		input = new ItemStack(TrueFishingItems.bait, 1, 1);
		output = new ItemStack(TrueFishingItems.bait, 8, 5);
		GameRegistry.addShapelessRecipe(output, input, input, input);
		// Boiles
		output = new ItemStack(TrueFishingItems.bait, 8, 6);
		GameRegistry.addShapelessRecipe(output, 
				Items.wheat_seeds, Items.sugar, TrueFishingItems.flour, Items.egg);
		// Hook, fishing line, reel, fishing rod
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.hook, 8), 
				" #", 
				" #", 
				"##", '#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.line), 
				"###", 
				"# #", 
				"###", '#', Items.string);
		GameRegistry.addRecipe(new ItemStack(TrueFishingItems.rod), 
				"  #", 
				" # ", 
				"#  ", '#', Items.stick);
	}
	
	/** Register smelting recipes */
	private static void registerSmeltingRecipes() {
		ItemStack input, output;
		// Smelting fishes;
		input = new ItemStack(TrueFishingItems.fishRaw);
		output = new ItemStack(TrueFishingItems.fish);
		for(int i=0; i < ItemFish.COUNT; i++) {
			input.setItemDamage(i);
			output.setItemDamage(i);
			GameRegistry.addSmelting(input, output, 0.1f);
		}
		// Smelting dough to bread
		input = new ItemStack(TrueFishingItems.bait, 1, 2);
		output = new ItemStack(Items.bread);
		GameRegistry.addSmelting(input, output, 0.1f);
		// Smelting pasta
		input.setItemDamage(5);
		output = new ItemStack(TrueFishingItems.pasta);
		GameRegistry.addSmelting(input, output, 0.1f);
	}
}
