package com.dipper.plugin.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;

public class VIP implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to equip kits!");
			return false;
		}
		final Player player = (Player) sender;
		if (!(player.hasPermission(new Permission("explodingmc.kit.vip")))) {
			player.sendMessage(ChatColor.RED + "You do not have permission for that kit.");
		}
		if (player.hasPermission(new Permission("explodingmc.kit.vip"))) {
			Inventory vip = Bukkit.createInventory(null, 27, "Kit VIP");
			player.playEffect(player.getLocation(), Effect.DOOR_TOGGLE, 1);
			ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta meta = diamondSword.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN + "[" + ChatColor.LIGHT_PURPLE + "VIP" + ChatColor.GREEN + "]");
			diamondSword.setItemMeta(meta);
			ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
			diamondPickaxe.setItemMeta(meta);
			ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
			diamondAxe.setItemMeta(meta);
			ItemStack diamondHelmet = new ItemStack(Material.DIAMOND_HELMET);
			diamondHelmet.setItemMeta(meta);
			ItemStack diamondChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
			diamondChestplate.setItemMeta(meta);
			ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
			diamondLeggings.setItemMeta(meta);
			ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
			diamondBoots.setItemMeta(meta);
			ItemStack bow = new ItemStack(Material.BOW);
			bow.setItemMeta(meta);
			ItemStack arrow = new ItemStack(Material.ARROW);

			diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			diamondChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			diamondBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			diamondPickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
			bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 5);
			bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
			bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 3);

			vip.addItem(diamondSword, diamondPickaxe, diamondAxe, diamondHelmet, diamondChestplate, diamondLeggings,
					diamondBoots, bow, arrow);
			player.openInventory(vip);
			player.sendMessage(ChatColor.AQUA + "You have opened kit VIP!");
			player.playEffect(player.getLocation(), Effect.DOOR_TOGGLE, 1);

			return true;
		}
		return false;

	}
}
