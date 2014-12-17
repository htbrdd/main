package com.wuppy.samsmod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySamThrowable extends EntityThrowable

{

	public EntitySamThrowable(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	
	public EntitySamThrowable(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntitySamThrowable(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition position)
	{
		if (!this.worldObj.isRemote)
		{
			worldObj.newExplosion(this, position.blockX, position.blockY, position.blockZ, 3F, true, true);
			this.setDead();
		}
		// TODO Auto-generated method stub
		
	}
	
	protected float getGravityVelocity()
	{
		return 0.07F;
	}
	
	protected float func_70182_d()
	{
		return .7F;
	
	}
	
	protected float func_70183_g()
	{
		return -20.0F;
	}
	



}
