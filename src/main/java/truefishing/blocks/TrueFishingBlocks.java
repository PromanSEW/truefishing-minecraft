package truefishing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class TrueFishingBlocks {
	
	/** Initialization */
	public static void init() {
		
	}
	
	/** Register {@code block} */
	public static void register(BaseBlock block) {
	    GameRegistry.registerBlock(block, block.getUnwrappedName());
	}
}
