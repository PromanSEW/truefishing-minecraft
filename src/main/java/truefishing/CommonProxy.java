package truefishing;

import cpw.mods.fml.common.event.*;
import truefishing.blocks.TrueFishingBlocks;
import truefishing.handler.CraftingHandler;
import truefishing.items.TrueFishingItems;
import truefishing.tileentities.TrueFishingTileEntities;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		TrueFishingBlocks.init();
		TrueFishingItems.init();
		CraftingHandler.init();
		TrueFishingTileEntities.registerTileEntities();
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
