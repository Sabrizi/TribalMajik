package TribalMajik.init;

import TribalMajik.Reference;
import TribalMajik.TribalMajik;
import TribalMajik.items.ItemDagger;
import TribalMajik.items.ItemFetish;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TribalMajikItems {

	public static Item obsidianShard;
	public static Item ancestorSkull;
	public static Item dagger;
	public static Item fetish;
	
	public static void preInit() {
		ModelBakery.addVariantName(TribalMajikItems.fetish, "tm:fetish_strength", "tm:fetish_speed",
				"tm:fetish_regen", "tm:fetish_dig");
	}
	    

	public static void init() {
		obsidianShard = new Item().setUnlocalizedName("obsidianShard").setCreativeTab(TribalMajik.tribalTab);
		ancestorSkull = new Item().setUnlocalizedName("ancestorSkull").setCreativeTab(TribalMajik.tribalTab);
		dagger = new ItemDagger().setUnlocalizedName("dagger").setCreativeTab(TribalMajik.tribalTab);
		fetish = new ItemFetish("fetish").setUnlocalizedName("fetish").setCreativeTab(TribalMajik.tribalTab);

	}

	public static void register() {
		GameRegistry.registerItem(obsidianShard, obsidianShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ancestorSkull, ancestorSkull.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dagger, dagger.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fetish, fetish.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(obsidianShard);
		registerRender(ancestorSkull);
		registerRender(dagger);
		registerRender(fetish, 0, "fetish_strength");
		registerRender(fetish, 1, "fetish_speed");
		registerRender(fetish, 2, "fetish_regen");
		registerRender(fetish, 3, "fetish_dig");		
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void registerRender(Item item, int meta, String fileName) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + fileName, "inventory"));
	}

}
