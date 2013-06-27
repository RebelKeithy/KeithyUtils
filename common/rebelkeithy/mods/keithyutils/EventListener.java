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
		actions.add(new Action("Metallurgy Wand"));
		
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
				
				System.out.println(event.action);
				
				if(player.isSneaking())
				{
					if(!player.worldObj.isRemote)
					{
						curr = (curr + 1) % actions.size();
						player.sendChatToPlayer("Command: " + actions.get(curr).name);
					}
				} 
				else 
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
				Class items = Class.forName("rebelkeithy.mods.aquaculature.AquacultureItems");
				Field field = items.getField("AdminFishingRod");
				Item rod = (Item) field.get(null);

				System.out.println(player.inventory.addItemStackToInventory(new ItemStack(rod)));
			
			} catch(Exception e) {
				if(!player.worldObj.isRemote)
					player.sendChatToPlayer("Aquaculture not found");
			}
		}
	}
}
