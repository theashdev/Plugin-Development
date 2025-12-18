package com.ash.permissions;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("perms").setExecutor(new PermsCommand(this));
    }

}
