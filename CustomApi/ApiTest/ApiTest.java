package com.ash.apiTest;

import com.ash.customApi.PokePlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ApiTest extends JavaPlugin implements Listener {

    PokePlugin api;

    @Override
    public void onEnable() {
       api = (PokePlugin) Bukkit.getPluginManager().getPlugin("PokePlugin");
        System.out.println(api.getWord());
        Bukkit.getPluginManager().registerEvents(this , this);

    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        api.sendMessage(e.getPlayer());
    }
}
