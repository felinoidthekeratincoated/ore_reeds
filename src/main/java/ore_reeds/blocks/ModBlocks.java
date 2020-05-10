package felinoid.ore_reeds.blocks;

import felinoid.ore_reeds.OreReeds;
import felinoid.ore_reeds.config.ReedsConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.*;


import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = OreReeds.MODID, bus = Bus.MOD)
public class ModBlocks {
    // Make creative mode tab
    static final ItemGroup tabOreReeds = (new ItemGroup("tabOreReeds") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(item_ore_essence);
        }		
    });

	public static Block ore_essence = new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3F, 3F)).setRegistryName("ore_essence");
	public static BlockItem item_ore_essence = getBlockItem(ore_essence);

	public static Block gem_essence = new Block(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(3F, 3F)).setRegistryName("gem_essence");
	public static BlockItem item_gem_essence = getBlockItem(gem_essence);
	
	public static Block blaze_reed = 
                        new BlockOreReed("blaze_reed", ReedsConfig.blaze);
	public static BlockItem item_blaze_reed = getBlockItem(blaze_reed);
	
	public static Block clay_reed = new BlockOreReed("clay_reed", ReedsConfig.clay);
	public static BlockItem item_clay_reed = getBlockItem(clay_reed);
	
	public static Block coal_reed = new BlockOreReed("coal_reed", ReedsConfig.coal);
	public static BlockItem item_coal_reed = getBlockItem(coal_reed);
	
	public static Block diamond_reed = new BlockOreReed("diamond_reed", ReedsConfig.diamond);
	public static BlockItem item_diamond_reed = getBlockItem(diamond_reed);
	
	public static Block emerald_reed = new BlockOreReed("emerald_reed", ReedsConfig.emerald);
	public static BlockItem item_emerald_reed = getBlockItem(emerald_reed);
	
	public static Block ender_pearl_reed = 
                new BlockOreReed("ender_pearl_reed", ReedsConfig.ender_pearl);
	public static BlockItem item_ender_pearl_reed = getBlockItem(ender_pearl_reed);
	
	public static Block glowstone_reed = new BlockOreReed("glowstone_reed", ReedsConfig.glowstone);
	public static BlockItem item_glowstone_reed = getBlockItem(glowstone_reed);
	
	public static Block gold_reed = new BlockOreReed("gold_reed", ReedsConfig.gold);
	public static BlockItem item_gold_reed = getBlockItem(gold_reed);
	
	public static Block iron_reed = new BlockOreReed("iron_reed", ReedsConfig.iron);
	public static BlockItem item_iron_reed = getBlockItem(iron_reed);
	
	public static Block lapis_reed = new BlockOreReed("lapis_reed", ReedsConfig.lapis);
	public static BlockItem item_lapis_reed = getBlockItem(lapis_reed);
	
	public static Block nether_quartz_reed = 
            new BlockOreReed("nether_quartz_reed", ReedsConfig.nether_quartz);
	public static BlockItem item_nether_quartz_reed = getBlockItem(nether_quartz_reed);
	
	public static Block obsidian_reed = 
            new BlockOreReed("obsidian_reed", ReedsConfig.obsidian);
	public static BlockItem item_obsidian_reed = getBlockItem(obsidian_reed);
	
	public static Block redstone_reed = 
            new BlockOreReed("redstone_reed", ReedsConfig.redstone);
	public static BlockItem item_redstone_reed = getBlockItem(redstone_reed);

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
        redstone_reed
    };

    public static BlockItem[] reedItems = {
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
        item_redstone_reed
    };
	
	public static void preInit() {}

	public static void init() {}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		event.getRegistry().registerAll(ore_essence, gem_essence);
        for (int i = 0; i < reedBlocks.length; ++i)
        {
            event.getRegistry().register(reedBlocks[i]);
        }
	}
	
	@SubscribeEvent
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
    {
		event.getRegistry().registerAll(item_ore_essence, item_gem_essence);
        for (int i = 0; i < reedItems.length; ++i)
        {
            event.getRegistry().register(reedItems[i]);
        }
	}
	
	private static BlockItem getBlockItem(Block blockIn)
	{
        Item.Properties properties = new Item.Properties().group(tabOreReeds);
		BlockItem item = new BlockItem(blockIn, properties);
        item.setRegistryName(blockIn.getRegistryName());
        return item;
	}
	/*
	private static void registerBlockItemModel(BlockItem item)
    {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}*/
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
    {/*
		registerBlockItemModel(item_ore_essence);
		registerBlockItemModel(item_gem_essence);

        for (int i = 0; i < reedItems.length; ++i)
        {
            registerBlockItemModel(reedItems[i]);
        }*/
	}
/*
    private static Block register(String key, Block block) {
        return Registry.register(Registry.BLOCK, key, block);
    }*/
}
