package com.wuppy.samsmod;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSamStone extends Block 
{
	String name = "samstone";
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public BlockSamStone()
	{
		super(Material.rock);
		setBlockName(SamsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 2);
		
		
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return SamsMod.samdust;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[3];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(SamsMod.MODID + ":" + name + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		switch(par2)
		{
		case 0:
			return icons[0];
		case 1:
			if(ForgeDirection.getOrientation(par1) == ForgeDirection.UP || ForgeDirection.getOrientation(par1) == ForgeDirection.DOWN)
				return icons[2];
			else
				return icons[1];
		default:
			System.out.println("Problems with getting the icon for BlockSamStone");
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 2; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}