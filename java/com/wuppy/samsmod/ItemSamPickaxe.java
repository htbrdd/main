package com.wuppy.samsmod;

import net.minecraft.item.ItemPickaxe;

public class ItemSamPickaxe extends ItemPickaxe 

{
	public ItemSamPickaxe(ToolMaterial material, String name)
	{
		super(material);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
		
	}

}
