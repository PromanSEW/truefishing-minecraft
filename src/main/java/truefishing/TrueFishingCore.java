package truefishing;

import truefishing.blocks.Blocks;
import truefishing.handler.CraftingHandler;
import truefishing.items.Items;
import truefishing.tileentities.TileEntities;

public class TrueFishingCore {
	
	public void preInit() {
		Blocks.init();
		Items.init();
		CraftingHandler.init();
		TileEntities.registerTileEntities();
	}
	
	public void init() {
		
	}
	
	public void postInit() {
		
	}
}
