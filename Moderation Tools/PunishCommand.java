package com.ash.testing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);

                    switch (args[1].toLowerCase()) {
                        case "kick":
                            target.kickPlayer(ChatColor.RED + "You have been kicked by " + player.getName());
                            player.sendMessage(ChatColor.GREEN + "You kicked " + target.getName());
                            break;
                        case "ban":
                            Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(), "You have been banned by " + player.getName(), null, player.getName());
                            target.kickPlayer(ChatColor.RED + "You have been banned by " + player.getName());
                            player.sendMessage(ChatColor.GREEN + "You banned " + target.getName());
                            break;
                        case "tempban":
                            Calendar cal = Calendar.getInstance() ;
                            cal.add(Calendar.HOUR, 12);
                            Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have been temporarily banned by " + player.getName(), null, player.getName());
                            target.kickPlayer(ChatColor.RED + "You have been temporarily banned by " + player.getName());
                            player.sendMessage(ChatColor.GREEN + "You temporarily banned " + target.getName());
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "Invalid action! Use: kick, ban, or tempban");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use: /punish <player> <kick/ban/tempban>");
            }

        }

        return false;
    }
}
