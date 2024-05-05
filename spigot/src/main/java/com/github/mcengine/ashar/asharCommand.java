package com.github.mcengine.ashar;

import com.github.mcengine.ashar.item;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class asharCommand implements CommandExecutor{
    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return;
        }

        // Check player permission
        if (!sender.hasPermission("op")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return;
        }

        // Check arguments range
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /ashar <itemType>");
            return;
        }

        // Check if arg[0] == "get" and arg[1] == "sword"
        if (args[0].equalsIgnoreCase("get") && args[1].equalsIgnoreCase("sword")) {
            Player player = (Player) sender;
            player.getInventory().addItem(asharItem.sword);
            return;
        }

        return;
    }
}