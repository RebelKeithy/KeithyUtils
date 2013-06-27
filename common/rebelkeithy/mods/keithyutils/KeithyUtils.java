package rebelkeithy.mods.keithyutils;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import rebelkeithy.mods.keithyutils.commands.KeithyCommands;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="KeithyUtils", name="Keithy Utils", version="1.0")
@NetworkMod(channels = {"KeithyUtils"}, clientSideRequired = true, serverSideRequired = false)
public class KeithyUtils {

	@SidedProxy(clientSide = "rebelkeithy.mods.keithyutils.ClientProxy", serverSide = "rebelkeithy.mods.keithyutils.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(value = "KeithyUtils")
	public static KeithyUtils instance;

	@ServerStarting
	public void serverStart(FMLServerStartingEvent event)
	{
		ServerCommandManager serverCommand = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
		serverCommand.registerCommand(new KeithyCommands());
	}
	 
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{       
		
	}

	@Init
	public void Init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventListener());
		proxy.registerTickHandlers();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
