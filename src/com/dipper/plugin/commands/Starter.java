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

public class Starter implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to equip kits!");
			return false;
		}

		Player player = (Player) sender;

		Inventory starter = Bukkit.createInventory(null, 27, "Kit Starter");
		player.playEffect(player.getLocation(), Effect.DOOR_TOGGLE, 1);
		ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta swordmeta = diamondSword.getItemMeta();
		swordmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		diamondSword.setItemMeta(swordmeta);
		ItemStack stone = new ItemStack(Material.STONE, 128);
		ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta pickmeta = ironPickaxe.getItemMeta();
		pickmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ItemStack ironAxe = new ItemStack(Material.IRON_AXE);
		ItemMeta axemeta = ironAxe.getItemMeta();
		axemeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ironAxe.setItemMeta(axemeta);
		ItemStack ironHelmet = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmmeta = ironHelmet.getItemMeta();
		helmmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ironHelmet.setItemMeta(helmmeta);
		ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestmeta = ironChestplate.getItemMeta();
		chestmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ironChestplate.setItemMeta(chestmeta);
		ItemStack ironLeggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta legmeta = ironLeggings.getItemMeta();
		legmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ironLeggings.setItemMeta(legmeta);
		ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta feetmeta = ironBoots.getItemMeta();
		feetmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		ironBoots.setItemMeta(feetmeta);
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Starter" + ChatColor.GRAY + "]");
		bow.setItemMeta(bowmeta);
		ItemStack arrow = new ItemStack(Material.ARROW, 64);
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);

		ironHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ironChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ironLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ironBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ironPickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);

		starter.addItem(diamondSword, stone, ironPickaxe, ironAxe, ironHelmet, ironChestplate, ironLeggings, ironBoots,
				bow, arrow, food);
		player.openInventory(starter);
		player.sendMessage(ChatColor.AQUA + "You have opened Kit Starter!");

		return true;
	}

}
