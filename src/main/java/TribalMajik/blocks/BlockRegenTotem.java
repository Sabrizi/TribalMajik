package TribalMajik.blocks;

import TribalMajik.tileentity.TileEntityTotem;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockRegenTotem extends BlockTotem {

	public World worldObj;
	public BlockPos pos;

	public BlockRegenTotem(Material material) {
		super(material);
		this.pos = BlockPos.ORIGIN;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTotem(10);
	}

}
