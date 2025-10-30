package com.ash.customSkulls;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomSkulls extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("skull").setExecutor(new SkullCommand());

    }

}
