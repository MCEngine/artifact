package com.github.mcengine;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.mcengine.commands.asharCommand;
import com.github.mcengine.items.asharItem;
import com.github.mcengine.items.material;
import com.github.mcengine.listeners.asharListener;

public class MCEngineArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register our item
        asharItem.sword();
        material.gezhange();
        material.hezh();
        material.rexgum();
        // Register our command
        getCommand("ashar").setExecutor(new asharCommand());
        // Register our listener
        getServer().getPluginManager().registerEvents(new asharListener(), this);
    }

    @Override
    public void onDisable() {
    }
}