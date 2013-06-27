package rebelkeithy.mods.keithyutils;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;

public class ItemStackMap<J> implements Map<ItemStack, J>
{
	Map<MapableItemStack, J> map;
	
	public ItemStackMap()
	{
		map = new HashMap<MapableItemStack, J>();
	}

	@Override
	public void clear() 
	{
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) 
	{
		if(key instanceof ItemStack)
		{
			return map.containsKey(new MapableItemStack((ItemStack) key));
		}
		
		return false;
	}

	@Override
	public boolean containsValue(Object value) 
	{
		return map.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<ItemStack, J>> entrySet() 
	{
		Set<Entry<ItemStack, J>> set = new HashSet<Entry<ItemStack, J>>();
		
		for(Entry<MapableItemStack, J> entry : map.entrySet())
		{
			set.add(new SimpleEntry<ItemStack, J>(entry.getKey().getItemStack(), entry.getValue()));
		}
		
		return set;
	}

	@Override
	public J get(Object key) 
	{
		if(key instanceof ItemStack)
		{
			return map.get(new MapableItemStack((ItemStack) key));
		}
		
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		return map.isEmpty();
	}

	@Override
	public Set<ItemStack> keySet() 
	{
		Set<ItemStack> set = new HashSet<ItemStack>();
		
		for(MapableItemStack stack : map.keySet())
		{
			set.add(stack.getItemStack());
		}
		
		return set;
	}

	@Override
	public J put(ItemStack key, J value) 
	{
		return map.put(new MapableItemStack(key), value);
	}

	@Override
	public void putAll(Map<? extends ItemStack, ? extends J> m) 
	{
		for(ItemStack stack : m.keySet())
		{
			map.put(new MapableItemStack(stack), map.get(stack));
		}
	}

	@Override
	public J remove(Object key) 
	{
		if(key instanceof ItemStack)
		{
			return map.remove(new MapableItemStack((ItemStack)key));
		}
		
		return null;
	}

	@Override
	public int size()
	{
		return map.size();
	}

	@Override
	public Collection<J> values() 
	{
		return map.values();
	}
	
}
