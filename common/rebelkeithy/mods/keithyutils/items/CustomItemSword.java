package rebelkeithy.mods.keithyutils.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class CustomItemSword extends ItemSword
{

	public CustomItemSword(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
	}
	
    public Item setTextureName(String par1Str)
    {
        super.func_111206_d(par1Str);
        return this;
    }
}
