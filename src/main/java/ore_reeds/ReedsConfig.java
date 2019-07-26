package felinoid.ore_reeds;

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
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;

@Config(modid = "ore_reeds")
public class ReedsConfig
{
    @Comment({"The block that clay and obsidian reeds can grow on,",
                "in addition to tier_1_block and tier_2_block."})
    public static String tier_0_block = "ore_reeds:ore_essence";

    @Comment(
        {"The block that iron, coal, glowstone, nether quartz, and redtone reeds can grow on,",
         "in addition to tier_2_block."})
    public static String tier_1_block = "ore_reeds:ore_essence";

    @Comment("The block that diamond, emerald, ender, blaze, lapis, and gold reeds can grow on.")
    public static String tier_2_block = "ore_reeds:gem_essence";
}
