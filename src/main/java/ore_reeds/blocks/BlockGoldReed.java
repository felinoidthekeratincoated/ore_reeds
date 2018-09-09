package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockGoldReed extends OreReed
{
	protected BlockGoldReed() 
	{
        this.setUnlocalizedName("ore_reeds:gold_reed");
        this.setRegistryName("gold_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn == ModBlocks.gem_essence;
    }
}