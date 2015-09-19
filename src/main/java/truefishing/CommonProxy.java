package truefishing;

import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.MinecraftForge;
import truefishing.blocks.TrueFishingBlocks;
import truefishing.entity.EntityFishingHook;
import truefishing.handler.CraftingHandler;
import truefishing.handler.DropHandler;
import truefishing.handler.GUIHandler;
import truefishing.items.TrueFishingItems;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		TrueFishingBlocks.registerBlocks();
		TrueFishingItems.registerItems();
		CraftingHandler.init();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}
	
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(TrueFishing.instance, new GUIHandler());
		EntityRegistry.registerModEntity(EntityFishingHook.class, "True Fishing Hook", 
				EntityRegistry.findGlobalUniqueEntityId(), TrueFishing.instance, 75, 1, true);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
