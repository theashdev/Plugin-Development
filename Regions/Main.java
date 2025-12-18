package com.ash.regions;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    private Cuboid cuboid;

    @Override
    public void onEnable() {
        getCommand("fill").setExecutor(new FillCommand());
        Bukkit.getPluginManager().registerEvents(this, this);

        World world = Bukkit.getWorld("world"); // change if needed

        Location pos1 = new Location(world, -56, 67, 328);
        Location pos2 = new Location(world, -61, 70, 337);

        cuboid = new Cuboid(pos1, pos2);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (cuboid != null && cuboid.contains(e.getPlayer().getLocation())) {
            e.getPlayer().spigot().sendMessage(
                    ChatMessageType.ACTION_BAR,
                    TextComponent.fromLegacyText("In the Region!")
            );
        }
    }
}
