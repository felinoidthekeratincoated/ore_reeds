package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockDiamondReed extends OreReed
{
	protected BlockDiamondReed() 
	{
        this.setUnlocalizedName("ore_reeds:diamond_reed");
        this.setRegistryName("diamond_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn == ModBlocks.gem_essence;
    }
}