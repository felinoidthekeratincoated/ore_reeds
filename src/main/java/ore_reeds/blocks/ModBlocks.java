package felinoid.ore_reeds.blocks;

import felinoid.ore_reeds.config.ReedsConfig;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.*;


import java.util.ArrayList;

public class ModBlocks {
    // Make creative mode tab
    static final CreativeTabs tabOreReeds = (new CreativeTabs("tabOreReeds") {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(item_ore_essence);
        }		
    });

	public static Block ore_essence = new BlockOreEssence();
	public static ItemBlock item_ore_essence = getItemBlock(ore_essence);

	public static Block gem_essence = new BlockGemEssence();
	public static ItemBlock item_gem_essence = getItemBlock(gem_essence);
	
	public static Block blaze_reed = 
                        new BlockOreReed("blaze_reed", ReedsConfig.blaze);
	public static ItemBlock item_blaze_reed = getItemBlock(blaze_reed);
	
	public static Block clay_reed = new BlockOreReed("clay_reed", ReedsConfig.clay);
	public static ItemBlock item_clay_reed = getItemBlock(clay_reed);
	
	public static Block coal_reed = new BlockOreReed("coal_reed", ReedsConfig.coal);
	public static ItemBlock item_coal_reed = getItemBlock(coal_reed);
	
	public static Block diamond_reed = new BlockOreReed("diamond_reed", ReedsConfig.diamond);
	public static ItemBlock item_diamond_reed = getItemBlock(diamond_reed);
	
	public static Block emerald_reed = new BlockOreReed("emerald_reed", ReedsConfig.emerald);
	public static ItemBlock item_emerald_reed = getItemBlock(emerald_reed);
	
	public static Block ender_pearl_reed = 
                new BlockOreReed("ender_pearl_reed", ReedsConfig.ender_pearl);
	public static ItemBlock item_ender_pearl_reed = getItemBlock(ender_pearl_reed);
	
	public static Block glowstone_reed = new BlockOreReed("glowstone_reed", ReedsConfig.glowstone);
	public static ItemBlock item_glowstone_reed = getItemBlock(glowstone_reed);
	
	public static Block gold_reed = new BlockOreReed("gold_reed", ReedsConfig.gold);
	public static ItemBlock item_gold_reed = getItemBlock(gold_reed);
	
	public static Block iron_reed = new BlockOreReed("iron_reed", ReedsConfig.iron);
	public static ItemBlock item_iron_reed = getItemBlock(iron_reed);
	
	public static Block lapis_reed = new BlockOreReed("lapis_reed", ReedsConfig.lapis);
	public static ItemBlock item_lapis_reed = getItemBlock(lapis_reed);
	
	public static Block nether_quartz_reed = 
            new BlockOreReed("nether_quartz_reed", ReedsConfig.nether_quartz);
	public static ItemBlock item_nether_quartz_reed = getItemBlock(nether_quartz_reed);
	
	public static Block obsidian_reed = 
            new BlockOreReed("obsidian_reed", ReedsConfig.obsidian);
	public static ItemBlock item_obsidian_reed = getItemBlock(obsidian_reed);
	
	public static Block redstone_reed = 
            new BlockOreReed("redstone_reed", ReedsConfig.redstone);
	public static ItemBlock item_redstone_reed = getItemBlock(redstone_reed);

    // Thaumcraft
    public static Block cinnabar_reed =
            new BlockOreReed("cinnabar_reed", ReedsConfig.cinnabar);
    public static ItemBlock item_cinnabar_reed = getItemBlock(cinnabar_reed);

    public static Block amber_reed =
            new BlockOreReed("amber_reed", ReedsConfig.amber);
    public static ItemBlock item_amber_reed = getItemBlock(amber_reed);

    public static Block[] reedBlocks = {
        blaze_reed, 
        clay_reed, 
        coal_reed, 
        diamond_reed, 
        emerald_reed, 
        ender_pearl_reed, 
        glowstone_reed, 
        gold_reed, 
        iron_reed,
        lapis_reed, 
        nether_quartz_reed, 
        obsidian_reed, 
        redstone_reed,
        cinnabar_reed,
        amber_reed
    };

    public static ItemBlock[] reedItems = {
        item_blaze_reed, 
        item_clay_reed, 
        item_coal_reed, 
        item_diamond_reed, 
        item_emerald_reed, 
        item_ender_pearl_reed, 
        item_glowstone_reed, 
        item_gold_reed, 
        item_iron_reed,
        item_lapis_reed, 
        item_nether_quartz_reed, 
        item_obsidian_reed, 
        item_redstone_reed,
        item_cinnabar_reed,
        item_amber_reed
    };
	
	public static void preInit() {}

	public static void init() {}

    public static boolean shouldRegister(Block block)
    {
        if (block == null) {
            return false;
        }
        if (block instanceof BlockOreReed) {
            BlockOreReed reed = (BlockOreReed)block;
            return reed.shouldRegister();
        }
        return true;
    }

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		event.getRegistry().registerAll(ore_essence, gem_essence);
        for (int i = 0; i < reedBlocks.length; ++i)
        {
            if (shouldRegister(reedBlocks[i]))
            {
                event.getRegistry().register(reedBlocks[i]);
            }
        }
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
		event.getRegistry().registerAll(item_ore_essence, item_gem_essence);
        for (int i = 0; i < reedItems.length; ++i)
        {
            if (shouldRegister(reedItems[i].getBlock()))
            {
                event.getRegistry().register(reedItems[i]);
            }
        }
	}
	
	private static ItemBlock getItemBlock(Block blockIn)
	{
		return (ItemBlock)(new ItemBlock(blockIn).setRegistryName(blockIn.getRegistryName()));
	}
	
	private static void registerItemBlockModel(ItemBlock item)
    {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
    {
		registerItemBlockModel(item_ore_essence);
		registerItemBlockModel(item_gem_essence);

        for (int i = 0; i < reedItems.length; ++i)
        {
            if (shouldRegister(reedItems[i].getBlock()))
            {
                registerItemBlockModel(reedItems[i]);
            }
        }
	}
}
