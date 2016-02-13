package com.dipper.plugin.inventory;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory menu = event.getInventory();
		// Makes sure it is the right menu.
		if (!menu.getTitle().equals("Player Menu"))
			return;

		// Checks if a player clicked the item.
		if (!(event.getWhoClicked() instanceof Player))
			return;

		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if (item.getType() == Material.COMPASS) {
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage("You have been succesfully teleported to spawn.");

			event.setCancelled(true);
			player.closeInventory();

			player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
		}
	}
}
