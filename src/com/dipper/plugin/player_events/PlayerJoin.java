package com.dipper.plugin.player_events;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.dipper.plugin.test;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class PlayerJoin implements Listener {

	private test plugin;

	public PlayerJoin(test pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		// Old Text Welcome Message:
		// String welcomeMessage = ChatColor.translateAlternateColorCodes('&',
		// plugin.getConfig().getString("Join Message"));
		// player.sendMessage(welcomeMessage);
		Player player = event.getPlayer();
		// New title welcome message:
		PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\":\"" + plugin.getConfig().getString("Welcome Title") + "\",\"color\":\""
						+ plugin.getConfig().getString("Title Color") + "\"}"),
				20, 40, 30);
		PacketPlayOutTitle welcomeSubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
				ChatSerializer.a("{\"text\":\"" + plugin.getConfig().getString("Welcome Subtitle") + "\",\"color\":\""
						+ plugin.getConfig().getString("Subtitle Color") + "\"}"),
				20, 40, 30);
		PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
		connection.sendPacket(welcomeTitle);
		connection.sendPacket(welcomeSubtitle);
	}
}
