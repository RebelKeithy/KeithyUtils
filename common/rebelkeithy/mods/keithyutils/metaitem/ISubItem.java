package rebelkeithy.mods.keithyutils.metaitem;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISubItem 
{

	String getUnlocalizedName(ItemStack par1ItemStack);

	Object getItemStack();

	void registerIcons(IconRegister par1IconRegister);

	ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);

	int getMaxItemUseDuration(ItemStack par1ItemStack);

	EnumAction getItemUseAction(ItemStack par1ItemStack);

	ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);

}
