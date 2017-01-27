package TribalMajik.init;

import TribalMajik.Reference;
import TribalMajik.blocks.BlockAncestorBones;
import TribalMajik.blocks.BlockDigTotem;
import TribalMajik.blocks.BlockRegenTotem;
import TribalMajik.blocks.BlockResistTotem;
import TribalMajik.blocks.BlockSpeedTotem;
import TribalMajik.blocks.BlockStrengthTotem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TribalMajikBlocks {

	public static Block totemBlock;
	public static Block ancestorBonesBlock;
	public static Block speedTotemBlock;
	public static Block strengthTotemBlock;
	public static Block digTotemBlock;
	public static Block regenTotemBlock;
	public static Block resistTotemBlock;
	
	public static void init(){
		//totemBlock = new BlockTotem(Material.wood).setUnlocalizedName("totemBlock");
		speedTotemBlock = new BlockSpeedTotem(Material.wood).setUnlocalizedName("speedTotemBlock");//this is what is finding the model
		strengthTotemBlock = new BlockStrengthTotem(Material.wood).setUnlocalizedName("strengthTotemBlock");
		digTotemBlock = new BlockDigTotem(Material.wood).setUnlocalizedName("digTotemBlock");
		regenTotemBlock = new BlockRegenTotem(Material.wood).setUnlocalizedName("regenTotemBlock");
		//resistTotemBlock = new BlockResistTotem(Material.wood).setUnlocalizedName("resistTotemBlock");
		
		
		ancestorBonesBlock = new BlockAncestorBones(Material.rock).setUnlocalizedName("ancestorBonesBlock");
	}
	
	public static void register(){
		//GameRegistry.registerBlock(totemBlock, totemBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ancestorBonesBlock, ancestorBonesBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(speedTotemBlock, speedTotemBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(strengthTotemBlock, strengthTotemBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(digTotemBlock, digTotemBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(regenTotemBlock, regenTotemBlock.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(resistTotemBlock, resistTotemBlock.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		//registerRender(totemBlock);
		registerRender(ancestorBonesBlock);
		registerRender(speedTotemBlock);
		registerRender(strengthTotemBlock);
		registerRender(digTotemBlock);
		registerRender(regenTotemBlock);
		//registerRender(resistTotemBlock);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
