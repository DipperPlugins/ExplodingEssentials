package com.dipper.plugin;

import java.util.logging.Logger;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.dipper.plugin.commands.Menu;
import com.dipper.plugin.commands.SetSpawn;
import com.dipper.plugin.commands.Spawn;
import com.dipper.plugin.commands.Staff;
import com.dipper.plugin.commands.Starter;
import com.dipper.plugin.commands.VIP;
import com.dipper.plugin.inventory.InventoryClick;
import com.dipper.plugin.player_events.PlayerChat;
import com.dipper.plugin.player_events.PlayerJoin;

public class test extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		registerCommands();
		registerEvents();
		registerConfig();
		registerPermissions();

		logger.info(pdfFile.getName() + " has been enabled! (V " + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been disabled. (V " + pdfFile.getVersion() + ")");
	}

	public void registerCommands() {
		getCommand("staff").setExecutor(new Staff(this));
		getCommand("starter").setExecutor(new Starter());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("menu").setExecutor(new Menu());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("vip").setExecutor(new VIP());
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryClick(), this);
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();

	}
	private void registerPermissions() {
		Permission p = new Permission("explodingmc.kit.vip", "explodingmc.setspawn");
		PluginManager pm = getServer().getPluginManager();
		
		pm.addPermission(p);
	}
}
