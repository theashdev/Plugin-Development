package com.ash.chatHover;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        // Clickable text
        TextComponent clickable = new TextComponent("§c§lClickable!");
        clickable.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help"));

        TextComponent none = new TextComponent("\n\nNothing!");

        // Hoverable text
        TextComponent hoverable = new TextComponent("\n\n§a§lHoverable!");
        hoverable.setHoverEvent(
                new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Woo! This is Hoverable"))
        );

        e.getPlayer().spigot().sendMessage(new BaseComponent[]{clickable, none, hoverable});

        // Discord message
        TextComponent start = new TextComponent("§7 This is My ");
        TextComponent discord = new TextComponent("§bDiscord");
        TextComponent period = new TextComponent("§7.");

        discord.setClickEvent(
                new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/discord")
        );
        discord.setHoverEvent(
                new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click for My Discord!"))
        );

        start.addExtra(discord);
        start.addExtra(period);

        e.getPlayer().spigot().sendMessage(start);
    }
}
