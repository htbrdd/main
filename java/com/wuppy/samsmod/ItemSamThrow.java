package com.wuppy.samsmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSamThrow extends Item 
{
public ItemSamThrow(String name)
{
	setCreativeTab(CreativeTabs.tabMisc);
	setUnlocalizedName(SamsMod.MODID + "_" + name);
	setTextureName(SamsMod.MODID + ":" + name);
		
}

@Override
public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
	if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
		--par1ItemStack.stackSize;
		}
	
	if (!par2World.isRemote)
	{
		par2World.spawnEntityInWorld(new EntitySamThrowable(par2World, par3EntityPlayer));
	}
	
	return par1ItemStack;
	
}

}
