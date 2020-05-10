package felinoid.ore_reeds.config;
/*
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;*/

//@Config(modid = "ore_reeds")
public class ReedsConfig
{
    public static ReedConfig blaze = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig clay = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig coal = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig diamond = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig emerald = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig ender_pearl = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig glowstone = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig gold = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig iron = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig lapis = new ReedConfig(new String[] {"ore_reeds:gem_essence"}, 2);

    public static ReedConfig nether_quartz = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig obsidian = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);

    public static ReedConfig redstone = new ReedConfig(new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2);
}
