package com.ash.holograms;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("spawnhologram").setExecutor(new SpawnHologramCommand());
    }


}
