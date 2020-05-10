package felinoid.ore_reeds;

import felinoid.ore_reeds.blocks.ModBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.*;
import net.minecraftforge.common.MinecraftForge;


@Mod(OreReeds.MODID)
public class OreReeds
{
	public static final String MODID = "ore_reeds";
	
	public static OreReeds instance;

    public OreReeds() {
        instance = this;
		MinecraftForge.EVENT_BUS.register(ModBlocks.class);
    }
}
