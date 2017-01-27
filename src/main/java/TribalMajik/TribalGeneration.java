package TribalMajik;

import java.util.Random;

import TribalMajik.init.TribalMajikBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TribalGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case -1:
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			break;
		}
	}

	public void generateNether(World world, Random rand, int x, int z) {

	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(TribalMajikBlocks.ancestorBonesBlock, world, rand, x, z, 2, 10, 50, 10, 100, Blocks.grass);
	}

	public void generateEnd(World world, Random rand, int x, int z) {

	}

	public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVeinSize,
			int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
		int veinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockHelper.forBlock(generateIn));
		
		for(int i = 0; i < chance; i++){
        	int xRand = chunkX * 16 + rand.nextInt(16);
        	int yRand = rand.nextInt(heightRange) + minY;
        	int zRand = chunkZ *16 + rand.nextInt(16);
        	
        	BlockPos newPos = new BlockPos(xRand, yRand, zRand);
        	gen.generate(world, rand, newPos);
        	}
	}
}
