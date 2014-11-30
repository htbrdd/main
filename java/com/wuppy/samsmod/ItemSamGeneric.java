package com.wuppy.samsmod;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;


public class ItemSamGeneric extends Item {
	
	public ItemSamGeneric(String name)
	{
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		
		
		
		
	}

}
