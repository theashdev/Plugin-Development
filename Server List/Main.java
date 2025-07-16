package com.ash.testing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {

        e.setMaxPlayers(6969);
        e.setMotd(ChatColor.AQUA + "Welcome to the Server!\n" + ChatColor.WHITE + "Ash Plugin Testing!");
        try {
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
