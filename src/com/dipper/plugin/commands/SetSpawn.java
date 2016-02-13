package com.dipper.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class SetSpawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (!(player.hasPermission(new Permission("explodingmc.setspawn")))) {
			player.sendMessage(ChatColor.RED + "You don't have access to that command.");
		}
		if (player.hasPermission(new Permission("explodingmc.setspawn"))) {
			if (label.equalsIgnoreCase("setspawn")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("This command can only be executed by players!");
					return false;
				}

				Player player1 = (Player) sender;
				Location location = player1.getLocation();

				if (args.length == 0) {

					player1.getWorld().setSpawnLocation(location.getBlockX(), location.getBlockY(),
							location.getBlockZ());
					player1.sendMessage(ChatColor.AQUA + "Successfully set spawn location");
					player.getWorld().playEffect(player.getLocation(), Effect.DOOR_TOGGLE, 1);
				} else {
					sender.sendMessage(ChatColor.RED + "Use \"/setspawn\" to set spawn location.");
				}
				return true;
			}
			return false;
		}
		return false;
	}
}