package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockBlazeReed extends OreReed
{
	protected BlockBlazeReed() 
	{
        this.setUnlocalizedName("ore_reeds:blaze_reed");
        this.setRegistryName("blaze_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn == ModBlocks.gem_essence;
    }
}