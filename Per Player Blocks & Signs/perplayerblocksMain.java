package com.ash.perplayerblocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("PerPlayerBlocks plugin enabled!");
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if (!e.isSneaking()) return;
        Block targetBlock = player.getTargetBlockExact(5);
        if (targetBlock == null) return;
        player.sendBlockChange(targetBlock.getLocation(), Material.REDSTONE_BLOCK.createBlockData());
    }
}
