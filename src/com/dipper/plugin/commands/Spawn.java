package com.dipper.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class Spawn implements CommandExecutor{
   
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 
        if (label.equalsIgnoreCase("spawn")) {
        if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by players!");
                return false;
            }
 
            Player player = (Player) sender;
           
            player.teleport(player.getWorld().getSpawnLocation());
            player.sendMessage(ChatColor.AQUA + "Teleported to spawn!");
    }
        return false;
}}