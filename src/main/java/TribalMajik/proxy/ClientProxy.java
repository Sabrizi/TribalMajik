package TribalMajik.proxy;

import TribalMajik.init.TribalMajikBlocks;
import TribalMajik.init.TribalMajikItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		TribalMajikItems.preInit();
		TribalMajikItems.registerRenders();
		TribalMajikBlocks.registerRenders();
	}
}
