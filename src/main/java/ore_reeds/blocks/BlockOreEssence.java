package felinoid.ore_reeds.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreEssence extends Block
{
    protected BlockOreEssence()
    {
        super(Material.ROCK);
        this.setUnlocalizedName("ore_reeds:ore_essence");
        this.setRegistryName("ore_essence");
        this.setCreativeTab(ModBlocks.tabOreReeds);
        this.setHarvestLevel("pickaxe", 0);
        this.setResistance(10.0F);
        this.setHardness(5.0F);
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.BLACK;
    }
    
}
