package com.wuppy.samsmod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;




public class BlockSamPlant extends BlockBush implements IGrowable
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	

	public BlockSamPlant()
	{
		super(Material.plants);
		setBlockName(SamsMod.MODID + "_" + "samplant");
		setCreativeTab((CreativeTabs)null);
		setHardness(0.0F);
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.25F, 1F);
		setStepSound(soundTypeGrass);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[3];
		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(SamsMod.MODID + ":" + "samplant" + i);
		
		}
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)public IIcon getIcon(int par1, int par2)
	{
		if(par2 < 0 || par2 >= 3)
		{
			System.out.println("Something is wrong with the metadata for BlockSamPlant!");
			return icons[par2];
			
		}
		else
			return icons[par2];
	}
	
	@Override
	public int getRenderType()
	{
		return 6;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        if (world.getBlockLightValue(x, y + 1, z) >= 9)
        {
            int l = world.getBlockMetadata(x, y, z);

            if (l < 2)
            {
                if (rand.nextInt(5) == 0)
                {
                    ++l;
                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
            }
        }
    }

	@Override
	public boolean func_149851_a(World world, int x,
			int y, int z, boolean var5)
	{
		// TODO Auto-generated method stub
		return world.getBlockMetadata(x,  y,  z) !=2;
	}

	@Override
	public boolean func_149852_a(World world, Random rand,
			int x, int y, int z) 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void func_149853_b(World world, Random rand,
			int x, int y, int z) 
	{
		// TODO Auto-generated method stub
		int next = world.getBlockMetadata(x,  y,  z) + 1;
		if(next > 2)
			next =2;
		
		world.setBlockMetadataWithNotify(x, y, z, next,2);
	}
}
