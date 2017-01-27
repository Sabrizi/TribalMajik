package TribalMajik.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import TribalMajik.TribalMajik;
import TribalMajik.init.TribalMajikItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAncestorBones extends Block {

	public BlockAncestorBones(Material material){
		super(material);
		this.setCreativeTab(TribalMajik.tribalTab);
		this.setHardness(2.5f);
		this.setHarvestLevel("pickaxe", 2);
	}
    
	//Allows for multiple items to drop from one block. Super Dope.
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        ret.add(new ItemStack(Items.bone, rand.nextInt(3)+1));
        ret.add(new ItemStack(TribalMajikItems.ancestorSkull, 1));
        return ret;
    }
}
