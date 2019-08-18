package felinoid.ore_reeds.integration.thaumcraft;

import felinoid.ore_reeds.blocks.BlockOreReed;
import felinoid.ore_reeds.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;
import thaumcraft.api.internal.CommonInternals;
import thaumcraft.api.ThaumcraftApi;

import java.util.Arrays;
import java.util.List;

import static thaumcraft.api.aspects.Aspect.*;

public class ThaumcraftAspects {
	private static final int ANY = OreDictionary.WILDCARD_VALUE;
	private final AspectEventProxy proxy;

	private ThaumcraftAspects(AspectEventProxy proxy)
    {
		this.proxy = proxy;
	}

	@SubscribeEvent
	public static void registerAspects(AspectRegistryEvent event)
    {
		ThaumcraftAspects handler = new ThaumcraftAspects(event.register);
		
		handler.registerItemAspects();
	}

    private void registerItemAspects()
    {
        registerOreReed(ModBlocks.blaze_reed, 0, new AspectList().add(FIRE, 2));
        registerOreReed(ModBlocks.clay_reed, 0, 
            new AspectList().add(WATER, 4).add(EARTH, 3));
        registerOreReed(ModBlocks.coal_reed, 0, 
            new AspectList().add(FIRE, 1).add(ENERGY, 1));
        registerOreReed(ModBlocks.diamond_reed, 0, 
            new AspectList().add(CRYSTAL, 1).add(DESIRE, 1));
        registerOreReed(ModBlocks.emerald_reed, 0, 
            new AspectList().add(CRYSTAL, 1).add(DESIRE, 1));
        registerOreReed(ModBlocks.ender_pearl_reed, 0, 
            new AspectList().add(MOTION, 1).add(ELDRITCH, 1));
        registerOreReed(ModBlocks.glowstone_reed, 0, 
            new AspectList().add(LIGHT, 8).add(SENSES, 4));
        registerOreReed(ModBlocks.gold_reed, 0, 
            new AspectList().add(METAL, 1).add(DESIRE, 1));
        registerOreReed(ModBlocks.iron_reed, 0, 
            new AspectList().add(METAL, 2));
        registerOreReed(ModBlocks.lapis_reed, 0, 
            new AspectList().add(SENSES, 1).add(EARTH, 1));
        registerOreReed(ModBlocks.nether_quartz_reed, 0, 
            new AspectList().add(CRYSTAL, 1));
        registerOreReed(ModBlocks.obsidian_reed, 0, 
            new AspectList().add(EARTH, 1).add(FIRE, 1).add(DARKNESS, 1));
        registerOreReed(ModBlocks.redstone_reed, 0, 
            new AspectList().add(ENERGY, 7));

        // Thaumcraft
        registerOreReed(ModBlocks.cinnabar_reed, 0, 
            new AspectList().add(METAL, 1).add(ALCHEMY, 1).add(DEATH, 1));
        registerOreReed(ModBlocks.amber_reed, 0, 
            new AspectList().add(CRYSTAL, 1).add(TRAP, 1));
// Each of these are 10 metal and 5 of the other thing:
// Copper: exchange
// Tin: crystal
// Lead: order
// Silver: desire

    }

    private void registerOreReed(Block block, int meta, AspectList aspects)
    {
        assert(block instanceof BlockOreReed);
        if (((BlockOreReed)block).shouldRegister())
        {
            registerReplace(block, meta, 
                aspects.add(EARTH, 1).add(FIRE, 1).add(PLANT, 1));
        }
    }

	//Convenience aspect registration methods

	private void register(Item item, int meta, AspectList aspects)
    {
		proxy.registerObjectTag(new ItemStack(item, 1, meta), aspects);
	}

	private void register(Block block, int meta, AspectList aspects)
    {
		proxy.registerObjectTag(new ItemStack(block, 1, meta), aspects);
	}

	private void register(String oreDict, AspectList aspects)
    {
		proxy.registerObjectTag(oreDict, aspects);
	}

    private void registerReplace(Block block, int meta, AspectList aspects)
    {
        ItemStack item = new ItemStack(block, 1, meta);
        CommonInternals.objectTags.remove(CommonInternals.generateUniqueItemstackId(item));
        register(block, meta, aspects);
    }

	private void registerComplex(Item item, int meta, AspectList aspects)
    {
		proxy.registerComplexObjectTag(new ItemStack(item, 1, meta), aspects);
	}

	private void registerComplex(Block block, int meta, AspectList aspects)
    {
		proxy.registerComplexObjectTag(new ItemStack(block, 1, meta), aspects);
	}
}
