package com.github.mcengine;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.mcengine.items.materialItem;
import com.github.mcengine.commands.materialCommand;

import com.github.mcengine.commands.asharCommand;
import com.github.mcengine.items.asharItem;
import com.github.mcengine.listeners.asharListener;

public class MCEngineArtifact extends JavaPlugin {

    @Override
    public void onEnable() {
        //////////////////////////////////////////
        // Register items, commands, listeners //
        ////////////////////////////////////////
        // material
        materialItem.gezhange();
        materialItem.hezh();
        materialItem.rexgum();
        getCommand("material").setExecutor(new materialCommand());

        // ashar
        asharItem.sword();
        getCommand("ashar").setExecutor(new asharCommand());
        getServer().getPluginManager().registerEvents(new asharListener(), this);
    }
    @Override
    public void onDisable() {
    }
}