package com.ash.holograms;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnHologramCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        String[] lines = {
                ChatColor.RED + "Line 1",
                ChatColor.GREEN + "Line 2",
                ChatColor.YELLOW + "Third Line!"
        };

        Location location = player.getLocation().clone();

        for (String line : lines) {
            ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(
                    location,
                    EntityType.ARMOR_STAND
            );

            stand.setInvisible(true);
            stand.setGravity(false);
            stand.setInvulnerable(true);
            stand.setMarker(true);

            stand.setCustomNameVisible(true);
            stand.setCustomName(line);

            location.subtract(0, 0.3, 0);
        }

        return true;
    }
}
