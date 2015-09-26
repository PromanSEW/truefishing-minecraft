package truefishing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import truefishing.items.TrueFishingItems;

public class TrueFishingBlocks {
	
	public static CornCrop corncrop = new CornCrop();
	public static PeaCrop peacrop = new PeaCrop();
	
	/** Register {@code block} */
	public static void register(BaseBlock block) {
	    GameRegistry.registerBlock(block, block.getUnwrappedName());
	}
	
	/** Register blocks */
	public static void registerBlocks() {
		GameRegistry.registerBlock(corncrop.setSeeds(TrueFishingItems.cornseeds), "crops.corn");
		GameRegistry.registerBlock(peacrop.setSeeds(TrueFishingItems.peaseeds), "crops.pea");
	}
}
