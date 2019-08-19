package felinoid.ore_reeds.config;

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

public class ReedConfig
{
    @Comment({"If any of these mods exist, this type of reed will be loaded.",
        "To always disable this reed type, make the list empty.",
        "To always enable it, put \"minecraft\" (without quotes) in this list."})
    public String[] mods;
    // Creafting options are disabled for now
    //@Comment({"Set to false to prevent this reed from being crafted."})
    //public static boolean craftEnabled;

    //@Comment({"Crafting this type of reed requires one of this item."})
    //public String mainIngredient;
    //@Comment({"Crafting this type of reed requires two of this item."})
    //public String sideIngredient;
    //@Comment({"After harvesting this reed, it can be crafted into this item."})
    //public String craftResult;
    @Comment({"A list of all the blocks this reed is allowed to grow on."})
    public String[] growBlocks;

    @Comment({"Decreases reed growth speed. This reed will grow at",
              "{1/slowdown} times the rate of sugarcane."})
    public int slowdown;
    //@Comment({"The number of reed required to craft into something else.",
    //          "This can be 1, 4, or 8."})
    //public int craftNumber;

    public ReedConfig(String[] mods, String mainIngredient, String sideIngredient, String craftResult, boolean craftEnabled, String[] growBlocks, int slowdown, int craftNumber) {
        this.mods = mods;
        //this.mainIngredient = mainIngredient;
        //this.sideIngredient = sideIngredient;
        //this.craftResult = craftResult;
        //this.craftEnabled = craftEnabled;
        this.growBlocks = growBlocks;
        this.slowdown = slowdown;
        //this.craftNumber = craftNumber;
    }
}
