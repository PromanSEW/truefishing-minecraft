package truefishing;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import truefishing.handler.GUIHandler;

@Mod(modid = TrueFishing.MODID, name = TrueFishing.MODNAME, version = TrueFishing.VERSION)
public class TrueFishing {
	
	public static final String MODID = "truefishing";
	public static final String MODNAME = "True Fishing";
	public static final String VERSION = "1.0.0.0";
	
	public static final String RES_PREFIX = MODID + ":";
	
	@Instance(value = MODID)
	public static TrueFishing instance;
	
	@SidedProxy(clientSide = MODID + ".ClientProxy", serverSide = MODID + ".ServerProxy")
	public static CommonProxy core = new CommonProxy();
	
	private static CreativeTabs creativeTab = new CreativeTab();
	
	/** Creative tab */
	public static CreativeTabs getCreativeTab() { return creativeTab; }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		core.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		core.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		core.postInit(event);
	}
}
