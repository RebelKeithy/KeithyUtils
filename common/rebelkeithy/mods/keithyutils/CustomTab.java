package rebelkeithy.mods.keithyutils;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomTab extends CreativeTabs
{
	int itemID;

	public CustomTab(String par2Str) 
	{
		super(par2Str);
		
		LanguageRegistry.instance().addStringLocalization("itemGroup." + par2Str, par2Str);
	}
	
	public void setItemID(int id)
	{
		itemID = id;
	}


    @SideOnly(Side.CLIENT)

    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex()
    {
    	if(Item.itemsList[itemID] != null)
    		return itemID;
    	else
    		return 1;
    }
}
