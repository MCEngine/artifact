package com.github.mcengine.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;

import com.github.mcengine.listeners.managerListener;

public class asharListener implements Listener {
    public final Map<UUID, Long> cooldowns = new HashMap<>();
    public final long cooldownDuration = 15000; // 15 seconds in milliseconds

    // If player right click item name ChatColor.GOLD + "Sword of the God"
    // It will send message to player Lightining Strike
    // make it stike to 5 enemy around player
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        if (managerListener.hasCooldown(playerUUID, cooldowns, cooldownDuration)) {
            long remainingTime = managerListener.getRemainingCooldown(playerUUID, cooldowns, cooldownDuration);
            player.sendMessage(ChatColor.YELLOW + "Cooldown remaining: " + remainingTime + " milliseconds");
            return;
        }
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item == null) return;
        if (!item.hasItemMeta()) return;
        if (!item.getItemMeta().hasDisplayName()) return;
        if (!item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Sword of the God")) return;
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        player.sendMessage(ChatColor.RED + "Lightning Strike!");
        player.getWorld().strikeLightning(player.getLocation());
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof LivingEntity && entity != player) {
                ((LivingEntity) entity).damage(40);
            }
        }
        managerListener.setCooldown(playerUUID, cooldowns);
    }
}