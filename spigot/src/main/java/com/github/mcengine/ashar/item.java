package com.github.mcengine.ashar;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;

public class item {
    public static itemStack sword;

    public static ItemStack sword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Sword of the God");

        meta.setLore(Arrays.asList(
            ChatColor.WHITE + "This is a powerful sword",
            ChatColor.RED + "It can slay any enemy"
            ));

        item.setItemMeta(meta);

        return sword = item;
    }
}