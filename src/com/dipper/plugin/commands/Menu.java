package com.dipper.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to equip kits!");
			return false;
		}

		Player player = (Player) sender;

		Inventory menu = Bukkit.createInventory(null, 9, "Player Menu");
		ItemStack spawnItem = nameItem(new ItemStack(Material.COMPASS), ChatColor.AQUA + "Teleport to Spawn!");
		menu.setItem(4, spawnItem);
		player.openInventory(menu);
		return true;
	}

	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta metadata = item.getItemMeta();
		metadata.setDisplayName(name);

		item.setItemMeta(metadata);
		return item;
	}

	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
}
