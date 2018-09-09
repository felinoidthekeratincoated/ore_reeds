package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockEnderPearlReed extends OreReed
{
	protected BlockEnderPearlReed() 
	{
        this.setUnlocalizedName("ore_reeds:ender_pearl_reed");
        this.setRegistryName("ender_pearl_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn == ModBlocks.gem_essence;
    }
}