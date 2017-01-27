package TribalMajik.blocks;

import java.util.List;
import java.util.Random;

import TribalMajik.EnumTotemType;
import TribalMajik.TribalMajik;
import TribalMajik.tileentity.TileEntityTotem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public abstract class BlockTotem extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public World worldObj;
	public BlockPos pos;

	public BlockTotem(Material material) {
		super(material);
		this.pos = BlockPos.ORIGIN;
		this.setCreativeTab(TribalMajik.tribalTab);
		this.setHardness(1.0f);
		this.setHarvestLevel("axe", 0);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	public void setWorldObj(World worldIn) {
		this.worldObj = worldIn;
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return World.doesBlockHaveSolidTopSurface(worldIn, pos.down());
	}

	// These three methods are for setting the direction state
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		state = state.withProperty(FACING, placer.getHorizontalFacing());
		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
	}
	// end state stuff

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullBlock() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list,
			Entity collidingEntity) {
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;

		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
	}

}
