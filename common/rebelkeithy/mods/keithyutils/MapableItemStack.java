package rebelkeithy.mods.keithyutils;

import net.minecraft.item.ItemStack;

public class MapableItemStack implements Comparable<MapableItemStack>
{
	private int itemID;
	private int meta;
	
	public MapableItemStack(ItemStack stack)
	{
		itemID = stack.itemID;
		meta = stack.getItemDamage();
	}
	
	public MapableItemStack(int itemID, int meta)
	{
		this.itemID = itemID;
		this.meta = meta;
	}
	
	@Override
	public int hashCode()
	{
		return meta & (itemID << 8);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof MapableItemStack)
		{
			MapableItemStack stack = (MapableItemStack)o;
			
			return itemID == stack.itemID && meta == stack.meta;
		}
		
		return false;
	}
	
	@Override
	public int compareTo(MapableItemStack o)
	{
		if(itemID != o.itemID)
			return itemID - o.itemID;
		else
			return meta - o.meta;
	}

	public ItemStack getItemStack() 
	{
		return new ItemStack(itemID, 1, meta);
	}
}
