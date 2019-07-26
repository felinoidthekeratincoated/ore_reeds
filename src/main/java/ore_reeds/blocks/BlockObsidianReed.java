package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockObsidianReed extends OreReed
{
	protected BlockObsidianReed() 
	{
        this.setUnlocalizedName("ore_reeds:obsidian_reed");
        this.setRegistryName("obsidian_reed");
	}
    
    /**
     * Returns true if an ore reed can grow on blockIn.
     */
    @Override
    protected boolean canGrowOn(Block blockIn)
    {
        String name = blockIn.getRegistryName().toString();
        // name had better not be null
    	return name.equals(ReedsConfig.tier_0_block) 
            || name.equals(ReedsConfig.tier_1_block)
            || name.equals(ReedsConfig.tier_2_block);
    }
}
