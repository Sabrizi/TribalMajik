package TribalMajik.tileentity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import TribalMajik.EnumTotemType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class TileEntityTotem extends TileEntity implements IUpdatePlayerListBox {

	private static Map classToNameMap = Maps.newHashMap();
	private static Map nameToClassMap = Maps.newHashMap();
	// speed potion effect
	private int potionEffect;

	public TileEntityTotem(int effect) {
		potionEffect = effect;
	}

	@Override
	public void update() {
		if (this.worldObj.getTotalWorldTime() % 80L == 0L) {
			int i = this.pos.getX();
			int j = this.pos.getY();
			int k = this.pos.getZ();
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) i, (double) j, (double) k, (double) (i + 1),
					(double) (j + 1), (double) (k + 1))).expand(10, 10, 10).addCoord(0.0D,
							/*
							 * (double) this.worldObj.getHeight()
							 */0.0D, 0.0D);
			List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
			Iterator iterator = list.iterator();
			EntityPlayer entityplayer;

			while (iterator.hasNext()) {
				entityplayer = (EntityPlayer) iterator.next();
				if (potionEffect == 10 || potionEffect == 11) {
					entityplayer.addPotionEffect(new PotionEffect(potionEffect, 100, 0));
				} else {
					entityplayer.addPotionEffect(new PotionEffect(potionEffect, 100, 1));
				}
			}
			this.spawnParticles(worldObj, pos);

		}

	}

	private NBTTagCompound customTileData;

	@Override
	public NBTTagCompound getTileData() {
		if (this.customTileData == null) {
			this.customTileData = new NBTTagCompound();
		}
		return this.customTileData;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("potionEffet", potionEffect);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.potionEffect = compound.getInteger("potionEffect");
	}

	static {
		addMapping(TileEntityTotem.class, "Totem");
	}

	public static void addMapping(Class cl, String id) {
		if (nameToClassMap.containsKey(id)) {
			throw new IllegalArgumentException("Duplicate id: " + id);
		} else {
			nameToClassMap.put(id, cl);
			classToNameMap.put(cl, id);
		}
	}

	private void spawnParticles(World worldIn, BlockPos pos) {
		Random random = worldIn.rand;
		double d0 = 0.0625D;

		for (int i = 0; i < 6; ++i) {
			double d1 = (double) ((float) pos.getX() + random.nextFloat());
			double d2 = (double) ((float) pos.getY() + random.nextFloat());
			double d3 = (double) ((float) pos.getZ() + random.nextFloat());

			worldIn.spawnParticle(EnumParticleTypes.SPELL,
					d1, d2, d3, 0.0D, 0.0D, 0.0D, new int[0]);
		}
	}
}
