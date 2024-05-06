package com.github.mcengine;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.mcengine.ashar.asharCommand;
import com.github.mcengine.ashar.asharItem;
import com.github.mcengine.ashar.asharListener;

public class MCEngineArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register our item
        asharItem.sword();
        asharItem.swordMaterialX();
        asharItem.swordMaterialY();
        asharItem.swordMaterialZ();
        // Register our command
        getCommand("ashar").setExecutor(new asharCommand());
        // Register our listener
        getServer().getPluginManager().registerEvents(new asharListener(), this);
    }

    @Override
    public void onDisable() {
    }
}