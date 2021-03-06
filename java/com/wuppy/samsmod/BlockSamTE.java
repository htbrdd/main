package com.wuppy.samsmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class BlockSamTE extends BlockContainer 
{
	
	private String name = "samte";
	
	private IIcon[] icons;
		
	
public BlockSamTE()
{
	super(Material.rock);
	setBlockName(SamsMod.MODID + "_" + name);
	setCreativeTab(CreativeTabs.tabBlock);
	setHardness(2F);
	setStepSound(soundTypeStone);
	setHarvestLevel("pickaxe", 2);
	
	
}



@Override
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
	icons = new IIcon[10];
	
	for (int i = 0; i < icons.length; i++)
	{
		icons[i] = par1IconRegister.registerIcon(SamsMod.MODID + ":" + "samte" + i);
		
	}
	
	
}

     @Override
     @SideOnly(Side.CLIENT)
     public IIcon getIcon(int par1, int par2)
     {
    	 return icons[par2];
     }
     
@Override
public TileEntity createNewTileEntity(World var1, int var2)
{
	//TODO Auto-generated method stub
	return new TileEntitySam();
}


@Override
public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
{
	TileEntity entity = world.getTileEntity(x, y, z);
	
	if(entity != null)
	{
		if(entity instanceof TileEntitySam)
		{
			TileEntitySam samEntity = (TileEntitySam) entity;
			
			if(!world.isRemote)
				samEntity.editCounter();
			
			return true;
		}
	}
	return false;
	}
	
}
















