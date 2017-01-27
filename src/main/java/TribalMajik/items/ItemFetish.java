package TribalMajik.items;

import java.util.List;

import TribalMajik.TribalMajik;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFetish extends Item{
	
    public ItemFetish(String unlocalizedName)
    {
    	super();
    	this.setUnlocalizedName(unlocalizedName);
        this.setHasSubtypes(true);
        //this.setMaxDamage(0);
        this.setCreativeTab(TribalMajik.tribalTab);
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
    {
        for (int i = 0; i < 4; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String fetishName = "";
		switch(stack.getItemDamage()){
		case 0:
			fetishName = "strength";
			break;
		case 1:
			fetishName = "speed";
			break;
		case 2:
			fetishName = "regen";
			break;
		case 3:
			fetishName = "dig";
			break;
		}
	    return super.getUnlocalizedName() + "." + fetishName; //(stack.getItemDamage() == 0 ? "0" : "1");
	}

}
