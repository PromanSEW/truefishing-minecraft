package truefishing;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import truefishing.blocks.TrueFishingBlocks;
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
		MinecraftForge.addGrassSeed(new ItemStack(TrueFishingItems.cornseeds), 10);
		MinecraftForge.addGrassSeed(new ItemStack(TrueFishingItems.peaseeds), 10);
		NetworkRegistry.INSTANCE.registerGuiHandler(TrueFishing.instance, new GUIHandler());
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
