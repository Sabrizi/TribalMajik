package TribalMajik.init;

import TribalMajik.tileentity.TileEntityTotem;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class TribalMajikTileEntities {
	
	

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityTotem.class, "tileEntitySpeedTotem");
    }

}