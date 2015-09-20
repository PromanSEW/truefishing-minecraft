package truefishing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import truefishing.items.TrueFishingItems;

public class TrueFishingBlocks {
	
	public static CornCrop corncrop = new CornCrop();
	public static PeaCrop peacrop = new PeaCrop();
	
	/** Register blocks */
	public static void registerBlocks() {
		register(corncrop.setSeeds(TrueFishingItems.cornseeds));
		register(peacrop.setSeeds(TrueFishingItems.peaseeds));
	}
	
	/** Register {@code block} */
	public static void register(BaseBlock block) {
	    GameRegistry.registerBlock(block, block.getUnwrappedName());
	}
}
