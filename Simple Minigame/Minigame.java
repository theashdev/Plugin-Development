package com.ash.minigames;

import com.ash.minigames.Listener.ConnectListener;
import com.ash.minigames.Listener.GameListener;
import com.ash.minigames.command.ArenaCommand;
import com.ash.minigames.manager.ArenaManager;
import com.ash.minigames.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigame extends JavaPlugin {
    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this),this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));

    }

    public ArenaManager getArenaManager() {return arenaManager; }

}
