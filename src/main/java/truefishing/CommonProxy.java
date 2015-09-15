package truefishing;

import cpw.mods.fml.common.event.*;
import truefishing.blocks.Blocks;
import truefishing.handler.CraftingHandler;
import truefishing.items.Items;
import truefishing.tileentities.TileEntities;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		Blocks.init();
		Items.init();
		CraftingHandler.init();
		TileEntities.registerTileEntities();
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
