package TribalMajik;

import net.minecraft.block.BlockPlanks;
import net.minecraft.util.IStringSerializable;

public enum EnumTotemType implements IStringSerializable {
	SPEED(1, "speed"),
    STRENGTH(2, "strength");

    private final int ID;
    private String name;
    public static final EnumTotemType[] META_LOOKUP = new EnumTotemType[values().length];
    
    private EnumTotemType(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public static EnumTotemType byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }
    
    public int getMetadata()
    {
        return this.ID;
    }

    public int getID() {
        return ID;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
