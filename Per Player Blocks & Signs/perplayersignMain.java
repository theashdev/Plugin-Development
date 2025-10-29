package com.ash.perplayerblocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e){

        Player player = e.getPlayer();

        if (e.isSneaking() && player.getTargetBlockExact(5) !=null && player.getTargetBlockExact(5).getType().equals(Material.OAK_SIGN)) {
            player.sendSignChange(player.getTargetBlockExact(5).getLocation(), new String[] {
                "This is",
                    "a",
                    "test!",
                    " "});

        }
    }


}
