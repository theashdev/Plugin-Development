package com.ash.customApi;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PokePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
       
    }
    public String getWord() {return "banana"; }

    public void sendMessage(Player player) {
        player.sendMessage("Cheese");
    }

}
