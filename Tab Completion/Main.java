package com.ash.completeTab;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("Fruit").setExecutor(new FruitCommand());
        getCommand("fruit").setTabCompleter(new FruitTab());
    }
}
