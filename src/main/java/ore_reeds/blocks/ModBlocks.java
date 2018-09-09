package felinoid.ore_reeds;

import net.minecraft.block.Block;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModBlocks {
    // Make creative mode tab
    static final CreativeTabs tabOreReeds = (new CreativeTabs("tabOreReeds") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(item_ore_essence);
        }		
    });

	public static Block ore_essence = new BlockOreEssence();
	public static ItemBlock item_ore_essence = getItemBlock(ore_essence);

	public static Block gem_essence = new BlockGemEssence();
	public static ItemBlock item_gem_essence = getItemBlock(gem_essence);
	
	public static Block blaze_reed = new BlockBlazeReed();
	public static ItemBlock item_blaze_reed = getItemBlock(blaze_reed);
	
	public static Block clay_reed = new BlockClayReed();
	public static ItemBlock item_clay_reed = getItemBlock(clay_reed);
	
	public static Block coal_reed = new BlockCoalReed();
	public static ItemBlock item_coal_reed = getItemBlock(coal_reed);
	
	public static Block diamond_reed = new BlockDiamondReed();
	public static ItemBlock item_diamond_reed = getItemBlock(diamond_reed);
	
	public static Block emerald_reed = new BlockEmeraldReed();
	public static ItemBlock item_emerald_reed = getItemBlock(emerald_reed);
	
	public static Block ender_pearl_reed = new BlockEnderPearlReed();
	public static ItemBlock item_ender_pearl_reed = getItemBlock(ender_pearl_reed);
	
	public static Block glowstone_reed = new BlockGlowstoneReed();
	public static ItemBlock item_glowstone_reed = getItemBlock(glowstone_reed);
	
	public static Block gold_reed = new BlockGoldReed();
	public static ItemBlock item_gold_reed = getItemBlock(gold_reed);
	
	public static Block iron_reed = new BlockIronReed();
	public static ItemBlock item_iron_reed = getItemBlock(iron_reed);
	
	public static Block lapis_reed = new BlockLapisReed();
	public static ItemBlock item_lapis_reed = getItemBlock(lapis_reed);
	
	public static Block nether_quartz_reed = new BlockNetherQuartzReed();
	public static ItemBlock item_nether_quartz_reed = getItemBlock(nether_quartz_reed);
	
	public static Block obsidian_reed = new BlockObsidianReed();
	public static ItemBlock item_obsidian_reed = getItemBlock(obsidian_reed);
	
	public static Block redstone_reed = new BlockRedstoneReed();
	public static ItemBlock item_redstone_reed = getItemBlock(redstone_reed);
	
	public static void preInit() {}

	public static void init() {}

	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ore_essence, gem_essence, blaze_reed, 
				clay_reed, coal_reed, diamond_reed, emerald_reed, ender_pearl_reed, 
				glowstone_reed, gold_reed, iron_reed, lapis_reed, nether_quartz_reed, 
				obsidian_reed, redstone_reed);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(item_ore_essence, item_gem_essence, 
				item_blaze_reed, item_clay_reed, item_coal_reed, item_diamond_reed, 
				item_emerald_reed, item_ender_pearl_reed, item_glowstone_reed, 
				item_gold_reed, item_iron_reed, item_lapis_reed, item_nether_quartz_reed, 
				item_obsidian_reed, item_redstone_reed);
	}
	
	private static ItemBlock getItemBlock(Block blockIn)
	{
		return (ItemBlock)(new ItemBlock(blockIn).setRegistryName(blockIn.getRegistryName()));
	}
	
	private static void registerItemBlockModel(ItemBlock item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerItemBlockModel(item_ore_essence);
		registerItemBlockModel(item_gem_essence);
		registerItemBlockModel(item_blaze_reed);
		registerItemBlockModel(item_clay_reed);
		registerItemBlockModel(item_coal_reed);
		registerItemBlockModel(item_diamond_reed);
		registerItemBlockModel(item_emerald_reed);
		registerItemBlockModel(item_ender_pearl_reed);
		registerItemBlockModel(item_glowstone_reed);
		registerItemBlockModel(item_gold_reed);
		registerItemBlockModel(item_iron_reed);
		registerItemBlockModel(item_lapis_reed);
		registerItemBlockModel(item_nether_quartz_reed);
		registerItemBlockModel(item_obsidian_reed);
		registerItemBlockModel(item_redstone_reed);
	}
}
