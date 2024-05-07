package com.github.mcengine.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.github.mcengine.items.material;

public class materialCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        // Check player permission
        if (!sender.hasPermission("op")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        // Check arguments range
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + help());
            return true;
        }

        Player player = (Player) sender;
        // Check if arg[0] == "get" and arg[1] == "gezhange" or "hezh" or "rexgum
        if (args.length >= 2 && args[0].equalsIgnoreCase("get")) {
            String itemType = args[1].toLowerCase();
            switch (itemType) {
            case "gezhange":
                player.getInventory().addItem(material.gezhange);
                return true;
            case "hezh":
                player.getInventory().addItem(material.hezh);
                return true;
            case "rexgum":
                player.getInventory().addItem(material.rexgum);
                return true;
            default:
                sender.sendMessage(ChatColor.RED + "Invalid item type!");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + help());
        }

        return true;
    }

    public static String help() {
        return "Usage: /material <get> <item>";
    }
}