package com.ash.testing;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("banner").setExecutor(new BannerCommand());
    }
}
