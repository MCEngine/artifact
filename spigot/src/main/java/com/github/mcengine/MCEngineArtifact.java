package com.github.mcengine;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.mcengine.ashar.asharItem;

public class MCEngineArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register our item
        asharItem.sword();
        // Register our command
        getCommand("ashar").setExecutor(new asharCommand());
    }

    @Override
    public void onDisable() {
    }
}