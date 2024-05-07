package com.github.mcengine.items;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

public class material {
    public static ItemStack gezhange;
    public static ItemStack hezh;
    public static ItemStack rexgum;

    public static ItemStack gezhange() {
        ItemStack item = new ItemStack(Material.DIAMOND);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "GeZhange");

        item.setItemMeta(meta);

        return gezhange = item;
    }

    public static ItemStack hezh() {
        ItemStack item = new ItemStack(Material.DIAMOND);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Hezh");

        item.setItemMeta(meta);

        return hezh = item;
    }

    public static ItemStack rexgum() {
        ItemStack item = new ItemStack(Material.DIAMOND);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "ReXgum");

        item.setItemMeta(meta);

        return rexgum = item;
    }

    public static ItemStack getItem(String item) {
        switch (item) {
            case "gezhange":
                return gezhange;
            case "hezh":
                return hezh;
            case "rexgum":
                return rexgum;
            default:
                return null;
        }
    }
}