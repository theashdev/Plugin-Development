package com.ash.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {

    private main main;

    public ReplyCommand(main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Invalid Usage! Use /reply <message>");
            return true;
        }

        if (!main.getRecentMessages().containsKey(player.getUniqueId())) {
            player.sendMessage(ChatColor.RED + "You haven't messaged anyone yet!");
            return true;
        }

        UUID uuid = main.getRecentMessages().get(player.getUniqueId());
        Player target = Bukkit.getPlayer(uuid);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "The person you messaged has gone offline!");
            return true;
        }

        if (target.equals(player)) {
            player.sendMessage(ChatColor.RED + "You cannot reply to yourself!");
            return true;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }

        String message = builder.toString().trim();

        player.sendMessage("You ->" + target.getName() + ": " + message);
        target.sendMessage(player.getName() + " -> You: " + message);

        main.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());
        main.getRecentMessages().put(target.getUniqueId(), player.getUniqueId());

        return true;
    }
}
