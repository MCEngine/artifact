package com.github.mcengine;

import org.bukkit.plugin.java.JavaPlugin;

public class MCEngineArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register our command
        getCommand("ashar").setExecutor(new asharCommand());
    }

    @Override
    public void onDisable() {
    }
}