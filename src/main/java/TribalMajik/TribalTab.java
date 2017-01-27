package TribalMajik;

import TribalMajik.init.TribalMajikItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TribalTab extends CreativeTabs{

	public TribalTab(String label){
		super(label);
		//this.setBackgroundImageName("image.png");
	}
	
	@Override
	public Item getTabIconItem(){
		return TribalMajikItems.obsidianShard;
	}
}
