package com.ash.testing;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register the event listener
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Resource Pack Plugin Enabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String url = " LINK IS REMOVED DUE TO PRIVACY ISSUES ";
        player.setResourcePack(url);
    }
}
