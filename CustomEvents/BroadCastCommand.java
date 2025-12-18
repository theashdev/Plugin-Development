package com.ash.customEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length >= 1) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }

                ServerBroadcastEvent event = new ServerBroadcastEvent(player, builder.toString());
                Bukkit.getPluginManager().callEvent(event);

                if (!event.isCancelled()) {
                    Bukkit.broadcastMessage(builder.toString());
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid Usage! Please use /broadcast <message>");
            }
        }

        return false;
    }
}
