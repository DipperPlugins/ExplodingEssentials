// Command that tests if 
package com.dipper.plugin.commands;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.dipper.plugin.test;

public class Staff implements CommandExecutor {

	private test plugin;

	public Staff(test pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("staff")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be executed by players!");
				return false;
			}
			Player player = (Player) sender;
			player.sendMessage("The staff on this server are:");
			List<String> serverAdmin = plugin.getConfig().getStringList("Server Admins");
			for (String admin : serverAdmin) {
				player.sendMessage(admin);
			}
			return true;
		}
		return false;
	}
}
