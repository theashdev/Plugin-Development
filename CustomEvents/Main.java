package com.ash.customEvents;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("broadcast").setExecutor(new BroadCastCommand());
        Bukkit.getPluginManager().registerEvents(this, this)

        ;
    }

    @EventHandler
    public void onBroadcast(ServerBroadcastEvent e) {
        System.out.println("Event Run!" + e.getMessage());

    }

}
