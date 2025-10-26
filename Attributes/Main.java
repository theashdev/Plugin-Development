package com.ash.attributes;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("boost").setExecutor(new BoostCommand());
    }


}
