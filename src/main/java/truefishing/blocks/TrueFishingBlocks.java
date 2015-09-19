package truefishing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class TrueFishingBlocks {
	
	/** Register blocks */
	public static void registerBlocks() {
		
	}
	
	/** Register {@code block} */
	public static void register(BaseBlock block) {
	    GameRegistry.registerBlock(block, block.getUnwrappedName());
	}
}
