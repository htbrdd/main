package com.wuppy.samsmod;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxySam extends CommonProxySam
{
	@Override
	public void registerRendering() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySamMob.class, new RenderSamMob(new ModelSamMob(), 0.5F));
	}
	
	@Override
	public void registerItemRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySamThrowable.class, new RenderSnowball(SamsMod.samthrow));
	}
}