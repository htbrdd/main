package com.wuppy.samsmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemSamSeed extends Item implements IPlantable
{
	private Block plant;
	
	private String name = "samseed";
	
	public ItemSamSeed(Block plant)
	{
		this.plant = plant;
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
        {
        	if(par3World.getBlock(par4, par5, par6) == Blocks.dirt || par3World.getBlock(par4, par5, par6) == Blocks.grass)
        	{
        		if (par3World.isAirBlock(par4, par5 + 1, par6))
        		{
        			par3World.setBlock(par4, par5 + 1, par6, this.plant);
        			--par1ItemStack.stackSize;
        			return true;
        		}
        		else
        		{
        			return false;
        		}
        	}
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

	protected boolean canPlaceBlockOn(Block block)
	{
		if(block == Blocks.dirt || block == Blocks.grass)
			return true;
		else 
			return false;
	}
	
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) 
	{
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) 
	{
		return plant;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) 
	{
		return 0;
	}
}
