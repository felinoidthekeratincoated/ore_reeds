package felinoid.ore_reeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OreReed extends Block implements net.minecraftforge.common.IPlantable
{
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
    protected static final AxisAlignedBB REED_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
    
	protected OreReed()
	{
		super(Material.PLANTS, MapColor.GRAY);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setCreativeTab(ModBlocks.tabOreReeds);
	}

	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return REED_AABB;
    }

	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getBlockState(pos.down()).getBlock() == this || this.checkForDrop(worldIn, pos, state))
        {
            if (worldIn.isAirBlock(pos.up()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 3)
                {
                    int j = ((Integer)state.getValue(AGE)).intValue();

                    // rand.nextBoolean() is there so these grow half the speed of normal reeds
                    if(rand.nextBoolean() 
                    		&& net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true))
                    {
	                    if (j == 15)
	                    {
	                        worldIn.setBlockState(pos.up(), this.getDefaultState());
	                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
	                    }
	                    else
	                    {
	                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
	                    }
	                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
        }
    }


    /**
     * Checks if this block can be placed exactly at the given position.
     */
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();

        if (block == this)
        {
            return true;
        }
        else if (!canGrowOn(block))
        {
            return false;
        }
        else
        {
            BlockPos blockpos = pos.down();

            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos.offset(enumfacing));

                if (iblockstate.getMaterial() == Material.LAVA)
                {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canBlockStay(worldIn, pos))
        {
            return true;
        }
        else
        {
            worldIn.destroyBlock(pos, true);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }
    
    /**
     * Returns true if an ore reed can grow on blockIn.
     */
    protected boolean canGrowOn(Block blockIn)
    {
        String name = blockIn.getRegistryName().toString();
        // name had better not be null
    	return name.equals(ReedsConfig.tier_1_block) 
            || name.equals(ReedsConfig.tier_2_block);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return this.getDefaultState();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
