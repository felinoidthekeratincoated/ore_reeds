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

@Config(modid = "ore_reeds")
public class ReedsConfig
{
    public static ReedConfig blaze = new ReedConfig(
        new String[] {"minecraft"}, 
        "minecraft:blaze_rod", "minecraft:blaze_rod", "minecraft:blaze_rod", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 8);

    public static ReedConfig clay = new ReedConfig(
        new String[] {"minecraft"}, 
        "minecraft:clay_ball", "minecraft:clay", "minecraft:clay_ball", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 1);

    public static ReedConfig coal = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockCoal", "stone", "minecraft:coal", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 8);

    public static ReedConfig diamond = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockDiamond", "stone", "gemDiamond", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 8);

    public static ReedConfig emerald = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockEmerald", "stone", "gemEmerald", 
        false, new String[] {"ore_reeds:gem_essence"}, 2, 8);

    public static ReedConfig ender_pearl = new ReedConfig(
        new String[] {"minecraft"}, 
        "enderpearl", "enderpearl", "enderpearl", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 8);

    public static ReedConfig glowstone = new ReedConfig(
        new String[] {"minecraft"}, 
        "dustGlowstone", "glowstone", "dustGlowstone", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 1);

    public static ReedConfig gold = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockGold", "stone", "ingotGold", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 8);

    public static ReedConfig iron = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockIron", "stone", "ingotIron", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 8);

    public static ReedConfig lapis = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockLapis", "stone", "gemLapis", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 4);

    public static ReedConfig nether_quartz = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockQuartz", "netherrack", "gemQuartz", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 4);

    public static ReedConfig obsidian = new ReedConfig(
        new String[] {"minecraft"}, 
        "obsidian", "obsidian", "obsidian", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 4);

    public static ReedConfig redstone = new ReedConfig(
        new String[] {"minecraft"}, 
        "blockRedstone", "stone", "dustRedstone", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 1);

    // Thaumcraft
    public static ReedConfig cinnabar = new ReedConfig(
        new String[] {"thaumcraft"}, 
        "", "stone", "", 
        true, new String[] {"ore_reeds:gem_essence", "ore_reeds:ore_essence"}, 2, 8);

    public static ReedConfig amber = new ReedConfig(
        new String[] {"thaumcraft"}, 
        "blockAmber", "stone", "gemAmber", 
        true, new String[] {"ore_reeds:gem_essence"}, 2, 8);
}
