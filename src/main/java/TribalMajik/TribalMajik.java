package TribalMajik;

import java.util.Random;

import TribalMajik.init.TribalMajikBlocks;
import TribalMajik.init.TribalMajikItems;
import TribalMajik.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TribalMajik {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static TribalTab tribalTab = new TribalTab("Tribal Majik");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		TribalMajikBlocks.init();
		TribalMajikBlocks.register();
		TribalMajikItems.init();
		TribalMajikItems.register();
		GameRegistry.registerWorldGenerator(new TribalGeneration(), 0);
		
		//maybe in a knapping stone item or something to get shards
		//Block.getBlockFromName("obsidian").onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ)
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		proxy.registerRenders();
		addRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
		
	public void addRecipes(){
		GameRegistry.addRecipe(new ItemStack(TribalMajikBlocks.speedTotemBlock),
			     " C ",
			     "AAA",
			     "BAB",
			     'A', Blocks.planks, 'B', Items.rabbit, 'C', TribalMajikItems.ancestorSkull
			     );
		
		GameRegistry.addRecipe(new ItemStack(TribalMajikBlocks.strengthTotemBlock),
			     " C ",
			     "AAA",
			     "BAB",
			     'A', Blocks.planks, 'B', Items.blaze_rod, 'C', new ItemStack(TribalMajikItems.fetish, 1, 0)
			     );
		
		GameRegistry.addRecipe(new ItemStack(TribalMajikBlocks.regenTotemBlock),
			     " C ",
			     "AAA",
			     "BAB",
			     'A', Blocks.planks, 'B', Items.ghast_tear, 'C', TribalMajikItems.ancestorSkull
			     );
		
		GameRegistry.addRecipe(new ItemStack(TribalMajikBlocks.digTotemBlock),
			     " C ",
			     "AAA",
			     "BAB",
			     'A', Blocks.planks, 'B', Items.iron_ingot, 'C', TribalMajikItems.ancestorSkull
			     );
		
		GameRegistry.addRecipe(new ItemStack(TribalMajikItems.dagger),
			     "  A",
			     " B ",
			     "C  ",
			     'A', TribalMajikItems.obsidianShard, 'B', Items.string, 'C', Items.bone
			     );
		
		GameRegistry.addShapelessRecipe(new ItemStack(TribalMajikItems.obsidianShard, 9), 
				Blocks.obsidian);
		
		//GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(Items.diamond, 2), 1F);
		//param 1: input; param2: output; param3: exp for smelting
	}
}
