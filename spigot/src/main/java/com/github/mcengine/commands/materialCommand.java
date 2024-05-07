package com.github.mcengine.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.mcengine.items.manager;
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

        if (args.length >= 2 && args[0].equalsIgnoreCase("get")) {
            ItemStack item = manager.getItem("material", args[1]);

            if (item != null) {
                player.getInventory().addItem(item);
                player.sendMessage(ChatColor.GREEN + "You have received " + item + "!");
            } else {
                player.sendMessage(ChatColor.RED + "Item not found!");
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