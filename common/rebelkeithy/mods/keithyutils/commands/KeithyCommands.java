package rebelkeithy.mods.keithyutils.commands;

import java.util.Arrays;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class KeithyCommands extends CommandBase
{

	@Override
	public String getCommandName() 
	{
		return "cape";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] astring) 
	{
		if(sender.getCommandSenderName().equals("RebelKeithy"))
		{
		    //REMOVE BEFORE RELEASING
			//System.out.println(Arrays.toString(astring));
			if(sender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)sender;
				NBTTagCompound tag = new NBTTagCompound();
				if(player.getEntityData().hasKey(EntityPlayer.PERSISTED_NBT_TAG))
				{
					tag = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				}
				tag.setString("CapeUrl", astring[0]);
				
				player.getEntityData().setCompoundTag(EntityPlayer.PERSISTED_NBT_TAG, tag);
			}
		}
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return null;
	}
	
}
