package rebelkeithy.mods.keithyutils.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cpw.mods.fml.relauncher.ReflectionHelper;

import net.minecraft.item.Item;

public class Reflector 
{
	public static void setItemTexture(Item item, String texture)
	{
		try {
			Method m = ReflectionHelper.findMethod(Item.class, item, new String[] {"func_111206_d"}, String.class);
			m.invoke(item, texture);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
