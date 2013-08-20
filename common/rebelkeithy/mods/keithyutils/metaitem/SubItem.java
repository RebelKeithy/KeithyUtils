package rebelkeithy.mods.keithyutils.metaitem;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SubItem 
{
	public int itemID;
	public int damage;
	public MetaItem item;
	
	public String unlocalizedName;
	private Icon itemIcon;
	private String textureName;
	
	public SubItem(int id)
	{
		itemID = id + 256;
		
		if(Item.itemsList[itemID] == null)
		{
			item = new MetaItem(id);
		} 
		else 
		{
			if(Item.itemsList[itemID] instanceof MetaItem)
			{
				item = (MetaItem) Item.itemsList[itemID];
			}
			else
			{
				System.out.println("CONFLICT @ " + id + " item slot already occupied by " + Item.itemsList[256 + id] + " while adding " + this);
			}
		}
		
		
		damage = item.addSubItem(this);
	}

    /**
     * returns this;
     */
    public SubItem setCreativeTab(CreativeTabs creativeTab)
    {
        item.setCreativeTab(creativeTab);
        return this;
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    public SubItem setUnlocalizedName(String name)
    {
        this.unlocalizedName = name;
        return this;
    }
    
    public SubItem setTextureName(String texture)
    {
    	this.textureName = texture;
    	return this;
    }
	
	public ItemStack getItemStack()
	{
		return getItemStack(1);
	}

	public ItemStack getItemStack(int size) 
	{
		return new ItemStack(itemID, size, damage);
	}

    public String getUnlocalizedName(ItemStack stack)
    {
    	return unlocalizedName;
    }

	public void registerIcons(IconRegister register) 
	{
        this.itemIcon = register.registerIcon(this.textureName);
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) 
	{
		return stack;
	}

	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return 0;
	}

	public EnumAction getItemUseAction(ItemStack stack) 
	{
		return EnumAction.none;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
	{
		return stack;
	}

	public Icon getIcon() 
	{
		return itemIcon;
	}

	public Icon getIcon(ItemStack stack) 
	{
		return getIcon();
	}

	public Icon getIcon(ItemStack stack, int pass) 
	{
		return getIcon(stack);
	}

	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) 
	{
		return getIcon(stack, renderPass);
	}
}
