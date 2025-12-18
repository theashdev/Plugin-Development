package com.ash.cooldown;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestCommand implements CommandExecutor {

    private final Map<UUID, Long> cooldown = new HashMap<>();
    private static final long COOLDOWN_TIME = TimeUnit.SECONDS.toMillis(10); // 10 seconds

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        long now = System.currentTimeMillis();

        if (!cooldown.containsKey(uuid)) {
            player.sendMessage(ChatColor.GREEN + "TestWorked!");
            cooldown.put(uuid, now);
            return true;
        }

        long lastUsed = cooldown.get(uuid);
        long remaining = COOLDOWN_TIME - (now - lastUsed);

        if (remaining <= 0) {
            player.sendMessage(ChatColor.GREEN + "TestWorked!");
            cooldown.put(uuid, now);
        } else {
            player.sendMessage(ChatColor.RED + "You must wait "
                    + TimeUnit.MILLISECONDS.toSeconds(remaining)
                    + " seconds to use this command again.");
        }

        return true;
    }
}
