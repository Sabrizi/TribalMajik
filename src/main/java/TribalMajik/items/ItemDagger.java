package TribalMajik.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class ItemDagger extends Item {
	
	public ItemDagger(){
		this.setMaxStackSize(1);
	}
	
	public ItemDagger(ToolMaterial obsidian) {	
		this.setMaxStackSize(1);
	}


	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking()) {
			player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0));
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100,2));
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 2));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 1));			
		}
		
		return stack;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
			
        return false;
    }

}

/**
 * public boolean itemInteractionForEntity(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_)
    {
        return false;
    }
 */

/**
 * Look at EntityPlayer for the onKillEntity for maybe sacrificing mobs and stuff
 * 
**/
/**
  public void onKillEntity(EntityLivingBase entity)
    {
        if (entity.isOnBlock)  [figure this out]
        {
            this.triggerAchievement(AchievementList.killEnemy);
        }

    }
  **/
