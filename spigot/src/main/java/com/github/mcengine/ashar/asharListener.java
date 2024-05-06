package com.github.mcengine.ashar;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;

public class asharListener implements Listener {
    private final Map<Player, Long> cooldowns = new HashMap<>();
    private final long cooldownDuration = 5000; // 5 seconds in milliseconds

    // If player right click item name ChatColor.GOLD + "Sword of the God"
    // It will send message to player Lightining Strike
    // make it stike to 5 enemy around player
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (hasCooldown(player)) {
            long remainingTime = getRemainingCooldown(player);
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
                ((LivingEntity) entity).damage(5);
            }
        }
        setCooldown(player);
    }

    private boolean hasCooldown(Player player) {
        if (cooldowns.containsKey(player)) {
            long cooldownTime = cooldowns.get(player);
            if (System.currentTimeMillis() < cooldownTime + cooldownDuration) {
                return true;
            } else {
                cooldowns.remove(player);
            }
        }
        return false;
    }

    private void setCooldown(Player player) {
        cooldowns.put(player, System.currentTimeMillis());
    }

    private long getRemainingCooldown(Player player) {
        long cooldownTime = cooldowns.get(player);
        long currentTime = System.currentTimeMillis();
        long remainingTime = cooldownTime + cooldownDuration - currentTime;
        return Math.max(0, remainingTime);
    }
}