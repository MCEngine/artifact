package com.github.mcengine.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class managerListener {
    public static boolean hasCooldown(UUID playerUUID, Map<UUID, Long> cooldowns, long cooldownDuration) {
        if (cooldowns.containsKey(playerUUID)) {
            long cooldownTime = cooldowns.get(playerUUID);
            if (System.currentTimeMillis() < cooldownTime + cooldownDuration) {
                return true;
            } else {
                cooldowns.remove(playerUUID);
            }
        }
        return false;
    }

    public static void setCooldown(UUID playerUUID, Map<UUID, Long> cooldowns) {
        cooldowns.put(playerUUID, System.currentTimeMillis());
    }

    public static long getRemainingCooldown(UUID playerUUID, Map<UUID, Long> cooldowns, long cooldownDuration) {
        long cooldownTime = cooldowns.get(playerUUID);
        long currentTime = System.currentTimeMillis();
        long remainingTime = cooldownTime + cooldownDuration - currentTime;
        return Math.max(0, remainingTime);
    }
}