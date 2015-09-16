package truefishing;

import cpw.mods.fml.common.event.*;
import net.minecraftforge.common.MinecraftForge;
import truefishing.blocks.TrueFishingBlocks;
import truefishing.handler.CraftingHandler;
import truefishing.handler.DropHandler;
import truefishing.items.TrueFishingItems;
import truefishing.tileentities.TrueFishingTileEntities;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		TrueFishingBlocks.init();
		TrueFishingItems.init();
		CraftingHandler.init();
		TrueFishingTileEntities.registerTileEntities();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
