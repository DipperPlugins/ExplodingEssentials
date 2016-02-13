package com.dipper.plugin.player_events;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

public class PlayerRecieveNameTag implements Listener {

	@EventHandler
	public void onNameTagReceive(AsyncPlayerReceiveNameTagEvent event) {
		Player player = event.getNamedPlayer();
		String name = player.getName();
		UUID uuid = player.getUniqueId();
		
		event.setTag(ChatColor.GOLD + name);
		event.setUUID(uuid);
	
	}
}
