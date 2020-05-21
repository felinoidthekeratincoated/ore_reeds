package felinoid.ore_reeds.blocks;

import felinoid.ore_reeds.config.ReedConfig;
import felinoid.ore_reeds.config.ReedsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.SoundType;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
//import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import java.util.Random;

public class BlockOreReed extends Block implements net.minecraftforge.common.IPlantable
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public ReedConfig stats;
    
	protected BlockOreReed(String name, ReedConfig config)
	{
		super(Block.Properties.create(Material.PLANTS, MaterialColor.GRAY).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0f, 0f).sound(SoundType.PLANT));
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
        this.stats = config;
        this.setRegistryName(name);
	}

	@Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

	@Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
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
                    int j = state.get(AGE);

                    // This is needed to decrease growth speed
                    if(rand.nextInt() % stats.slowdown == 0
                    		&& net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true))
                    {
	                    if (j == 15)
	                    {
	                        worldIn.setBlockState(pos.up(), this.getDefaultState());
	                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
	                    }
	                    else
	                    {
	                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
	                    }
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                    }
                }
            }
        }
    }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    @Override
    public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos pos)
    {
        BlockState state = worldIn.getBlockState(pos.down());
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

            for (Direction direction : Direction.Plane.HORIZONTAL)
            {
                BlockState blockstate = worldIn.getBlockState(blockpos.offset(direction));

                if (blockstate.getMaterial() == Material.LAVA)
                {
                    return true;
                }
            }

            return false;
        }
    }

    protected final boolean checkForDrop(World worldIn, BlockPos pos, BlockState state)
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
        return this.isValidPosition(null, worldIn, pos);
    }
    
    /**
     * Returns true if an ore reed can grow on blockIn.
     */
    protected boolean canGrowOn(Block blockIn)
    {
        String name = blockIn.getRegistryName().toString();
    	return Arrays.asList(stats.growBlocks).contains(name);
    }

    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     *//*
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }*/

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.Beach;
    }
    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return getDefaultState();
    }
}
