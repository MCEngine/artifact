package com.github.mcengine.listeners;

public class managerListener {
    private boolean hasCooldown(UUID playerUUID) {
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

    private void setCooldown(UUID playerUUID) {
        cooldowns.put(playerUUID, System.currentTimeMillis());
    }

    private long getRemainingCooldown(UUID playerUUID) {
        long cooldownTime = cooldowns.get(playerUUID);
        long currentTime = System.currentTimeMillis();
        long remainingTime = cooldownTime + cooldownDuration - currentTime;
        return Math.max(0, remainingTime);
    }
}