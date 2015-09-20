package truefishing.items;

import cpw.mods.fml.common.registry.GameRegistry;
import truefishing.blocks.TrueFishingBlocks;

public class TrueFishingItems {
	
	public static final ItemBait bait = new ItemBait();
	public static final ItemFish fish = new ItemFish(false);
	public static final ItemFish fishRaw = new ItemFish(true);
	public static final ItemInventorySet invset = new ItemInventorySet();
	public static final ItemHook hook = new ItemHook();
	public static final ItemLine line = new ItemLine();
	public static final ItemPasta pasta = new ItemPasta();
	public static final ItemReel reel = new ItemReel();
	public static final ItemRod rod = new ItemRod();
	public static final BaseItem flour = new BaseItem("flour");
	public static final BaseSeeds cornseeds = new BaseSeeds("corn", TrueFishingBlocks.corncrop);
	public static final BaseSeeds peaseeds = new BaseSeeds("pea", TrueFishingBlocks.peacrop);
	
	/** Register item */
	public static void registerItem(BaseItem item) {
		GameRegistry.registerItem(item, item.getUnwrappedName());
	}
	
	/** Register items */
	public static void registerItems() {
		GameRegistry.registerItem(fish, "fish");
		GameRegistry.registerItem(fishRaw, "fishRaw");
		GameRegistry.registerItem(invset, "invset");
		GameRegistry.registerItem(pasta, "pasta");
		GameRegistry.registerItem(cornseeds, "seeds.corn");
		GameRegistry.registerItem(peaseeds, "seeds.pea");
		registerItem(bait);
		registerItem(flour);
		registerItem(hook);
		registerItem(line);
		registerItem(reel);
		registerItem(rod);
	}
}
