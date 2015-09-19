package truefishing;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = TrueFishing.MODID, name = TrueFishing.MODNAME, version = TrueFishing.VERSION)
public class TrueFishing {
	
	public static final String MODID = "truefishing";
	public static final String MODNAME = "True Fishing";
	public static final String VERSION = "1.0.0.0";
	
	public static final String RES_PREFIX = MODID + ":";
	
	@Instance(MODID)
	public static TrueFishing instance;
	
	@SidedProxy(clientSide = MODID + ".ClientProxy", serverSide = MODID + ".ServerProxy")
	public static CommonProxy core = new CommonProxy();
	
	/** Creative tab */
	public static final CreativeTabs creativeTab = new CreativeTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		core.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		core.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		core.postInit(event);
	}
}
