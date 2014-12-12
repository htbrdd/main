package com.wuppy.samsmod;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxySam extends CommonProxySam
{

	
	@Override
	public void registerRendering()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySamMob.class, new RenderSamMob(new ModelSamMob(), 0.5F));
		
	}
}
