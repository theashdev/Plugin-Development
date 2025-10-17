package com.ash.guiscreation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())
                .equals(ChatColor.RED.toString() + ChatColor.BOLD + "Tools Menu!")
                && e.getCurrentItem() != null) {

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 0:
                    // Slot 0 action (currently empty)
                    break;

                case 20: // Random TP
                    List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                    if (players.size() > 1) {
                        players.remove(player); // don't teleport to self
                        Player target = players.get(new Random().nextInt(players.size()));
                        player.teleport(target.getLocation());
                        player.sendMessage(ChatColor.RED + "You teleported to " + target.getName() + "!");
                    } else {
                        player.sendMessage(ChatColor.RED + "No other players to teleport to!");
                    }
                    break;

                case 22: // Self kill
                    player.setHealth(0);
                    player.sendMessage(ChatColor.RED + "You killed yourself!");
                    break;

                case 24: // Clear Inventory
                    player.closeInventory();
                    player.getInventory().clear();
                    player.sendMessage(ChatColor.RED + "You cleared your inventory!");
                    break;

                default:
                    return;
            }

            player.closeInventory();
        }
    }
}
