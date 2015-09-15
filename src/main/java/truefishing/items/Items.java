package truefishing.items;

import cpw.mods.fml.common.registry.GameRegistry;

public class Items {
	
	public static final Fish fish = new Fish(false);
	public static final Fish fishRaw = new Fish(true);
	
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
	}
}
