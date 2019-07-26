package felinoid.ore_reeds;

import net.minecraft.block.Block;

public class BlockEmeraldReed extends OreReed
{
	protected BlockEmeraldReed() 
	{
        this.setUnlocalizedName("ore_reeds:emerald_reed");
        this.setRegistryName("emerald_reed");
	}
    
	@Override
    protected boolean canGrowOn(Block blockIn)
    {
    	return blockIn.getRegistryName().toString().equals(ReedsConfig.tier_2_block);
    }
}
