package rebelkeithy.mods.keithyutils.particleregistry;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ParticleRegistry 
{
	private static Map<String, Class<? extends EntityFX>> particleList = new HashMap<String, Class<? extends EntityFX>>();
	
	public static void registerParticle(String name, Class<? extends EntityFX> particle)
	{
		particleList.put(name, particle);
	}

    @SideOnly(Side.CLIENT)
	public static void spawnParticle(String string, World par1World, double x, double y, double z, double r, double g, double b) 
	{
		Class entityClass = particleList.get(string);
		if(entityClass != null)
		{
			Constructor entityConstructor;
			try {
				entityConstructor = entityClass.getConstructor(World.class, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
				if(entityConstructor != null)
				{
					EntityFX entity = (EntityFX) entityConstructor.newInstance(par1World, x, y, z, r, g, b);
					entity.setRBGColorF((float)r, (float)g, (float)b);
					Minecraft.getMinecraft().effectRenderer.addEffect(entity);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
