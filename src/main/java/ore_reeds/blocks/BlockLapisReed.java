package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockLapisReed extends OreReed
{
	protected BlockLapisReed() 
	{
        this.setUnlocalizedName("ore_reeds:lapis_reed");
        this.setRegistryName("lapis_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn.getRegistryName().toString().equals(ReedsConfig.tier_2_block);
    }
}
