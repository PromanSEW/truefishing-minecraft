package truefishing.items;

import cpw.mods.fml.common.registry.GameRegistry;

public class TrueFishingItems {
	
	public static final ItemBait bait = new ItemBait();
	public static final ItemFish fish = new ItemFish(false);
	public static final ItemFish fishRaw = new ItemFish(true);
	public static final ItemHook hook = new ItemHook();
	public static final ItemLine line = new ItemLine();
	public static final ItemPasta pasta = new ItemPasta();
	public static final ItemReel reel = new ItemReel();
	public static final ItemRod rod = new ItemRod();
	public static final ItemInventorySet invset = new ItemInventorySet();
	public static final BaseItem flour = new BaseItem("flour");
	
	/** Initialization */
	public static void init() {
		registerItems();
	}
	
	/** Register item */
	public static void registerItem(BaseItem item) {
		GameRegistry.registerItem(item, item.getUnwrappedName());
	}
	
	/** Register items */
	private static void registerItems() {
		GameRegistry.registerItem(fish, "fish");
		GameRegistry.registerItem(fishRaw, "fishRaw");
		GameRegistry.registerItem(invset, "invset");
		GameRegistry.registerItem(pasta, "pasta");
		registerItem(bait);
		registerItem(flour);
		registerItem(hook);
		registerItem(line);
		registerItem(reel);
		registerItem(rod);
	}
}
