package felinoid.ore_reeds;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.*;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = OreReeds.MODID, name = OreReeds.NAME, version = OreReeds.VERSION)

public class OreReeds
{
	public static final String NAME = "Ore Reeds";
	public static final String MODID = "ore_reeds";
	public static final String VERSION = "1.12.2-1.0.3";
	
	@Mod.Instance("ore_reeds")
	public static OreReeds instance;
	
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(ModBlocks.class);
	}
	
	@Mod.EventHandler
	public void init(final FMLInitializationEvent event) {}
	
	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event) {}
}
