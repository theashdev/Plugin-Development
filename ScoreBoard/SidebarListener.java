package com.ash.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.UUID;

public class SidebarListener implements Listener {

    private final HashMap<UUID, Integer> blocksBroken = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        // Initialize data if first join
        blocksBroken.putIfAbsent(player.getUniqueId(), 0);

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("TestBoard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Test Board!");

        // Lines (top to bottom: higher score = higher line)
        obj.getScore(ChatColor.YELLOW + "www.winterstudios.xyz").setScore(3);
        obj.getScore(" ").setScore(2);

        // Blocks Broken Team
        Team blocksTeam = board.registerNewTeam("blocks_broken");

        String entry = ChatColor.DARK_BLUE.toString(); // unique invisible entry
        blocksTeam.addEntry(entry);

        blocksTeam.setPrefix(ChatColor.BLUE + "Blocks Broken: ");
        blocksTeam.setSuffix(ChatColor.YELLOW.toString() + blocksBroken.get(player.getUniqueId()));

        obj.getScore(entry).setScore(1);

        player.setScoreboard(board);
    }
}
