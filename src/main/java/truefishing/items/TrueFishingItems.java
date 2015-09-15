package truefishing.items;

import cpw.mods.fml.common.registry.GameRegistry;

public class TrueFishingItems {
	
	public static final ItemFish fish = new ItemFish(false);
	public static final ItemFish fishRaw = new ItemFish(true);
	public static final ItemHook hook = new ItemHook();
	public static final ItemLine line = new ItemLine();
	public static final ItemReel reel = new ItemReel();
	public static final ItemRod rod = new ItemRod();
	
	/** Initialization */
	public static void init() {
		registerItems();
	}
	
	public static void registerItem(BaseItem item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void registerItems() {
		registerFishes();
	}
	
	private static void registerFishes() {
		GameRegistry.registerItem(fish, "fish");
		GameRegistry.registerItem(fishRaw, "fishRaw");
		GameRegistry.registerItem(hook, "hook");
		GameRegistry.registerItem(line, "line");
		GameRegistry.registerItem(reel, "reel");
		GameRegistry.registerItem(rod, "rod");
	}
}
