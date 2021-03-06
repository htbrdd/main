package com.wuppy.samsmod;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSamPlant extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random rand,
			int x, int y, int z) 
	{
		for (int l = 0; 1 < 64; ++l)
		{
			int x1 = x + rand.nextInt(8) - rand.nextInt(8);
			int y1 = y + rand.nextInt(4) - rand.nextInt(4);
			int z1 = z + rand.nextInt(8) - rand.nextInt(8);
			
			if (SamsMod.samPlant.canPlaceBlockAt(world, x1, y1, z1) && world.getBlock(x1,  y1 - 1,  z1) == Blocks.grass)
			{
				world.setBlock(x1,  y1,  z1,  SamsMod.samPlant, rand.nextInt(3), 2);
			}
			return true;
			
		}
	}

}
