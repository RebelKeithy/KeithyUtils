package rebelkeithy.mods.keithyutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventListener 
{
	List<Action>actions;
	int curr;
	
	private void initActions()
	{
		actions = new ArrayList<Action>();
		
		actions.add(new ActionFishRod("Admin Rod"));
		actions.add(new ActionMetallurgyWand("Metallurgy Wand"));
		
		curr = -1;
	}
	
	@ForgeSubscribe
	public void rightClick(PlayerInteractEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		
		if(player.username.equals("RebelKeithy"))
		{
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == Item.stick.itemID && event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR)
			{
				//if(player.worldObj.isRemote)
				//	return; 
				
				if(actions == null)
					initActions();
				
				if(player.isSneaking())
				{
					if(!player.worldObj.isRemote)
					{
						curr = (curr + 1) % actions.size();
						player.addChatMessage("Command: " + actions.get(curr).name);
					}
				} 
				else if(curr >= 0 && curr < actions.size())
				{
					actions.get(curr).action(event);
				}
			}
		}
	}
	
	private class Action
	{
		public String name;
		
		public Action(String name)  { this.name = name; }
		
		public void action(PlayerInteractEvent event) {}
	}
	
	private class ActionFishRod extends Action
	{
		ActionFishRod(String name)
		{
			super(name);
		}

		public void action(PlayerInteractEvent event) 
		{
			EntityPlayer player = event.entityPlayer;
			
			try
			{
				Class items = Class.forName("rebelkeithy.mods.aquaculture.AquacultureItems");
				Field field = items.getField("adminFishingRod");
				Item rod = (Item) field.get(null);
				System.out.println(player.inventory.addItemStackToInventory(new ItemStack(rod)));
			
			} catch(Exception e) {
				if(!player.worldObj.isRemote)
					player.addChatMessage("Aquaculture not found");
			}
		}
	}
	
	private class ActionMetallurgyWand extends Action
	{
		ActionMetallurgyWand(String name)
		{
			super(name);
		}

		public void action(PlayerInteractEvent event) 
		{
			EntityPlayer player = event.entityPlayer;
			
			try
			{
				Class items = Class.forName("rebelkeithy.mods.metallurgy.metals.MetallurgyMetals");
				Field field = items.getField("debug");
				Item rod = (Item) field.get(null);
				System.out.println(player.inventory.addItemStackToInventory(new ItemStack(rod)));
			
			} catch(Exception e) {
				if(!player.worldObj.isRemote)
					player.addChatMessage("Aquaculture not found");
				System.out.println(e);
			}
		}
	}
}
