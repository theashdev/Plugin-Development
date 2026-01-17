package com.ash.minigames.instance;

import com.ash.minigames.GameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "Game Started ! Mine 5 Blocks Fastest to Win!");

        for(UUID uuid : arena.getPlayers()){
            points.put(uuid, 0);

        }
    }

    public void addPoint(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;
        if (playerPoints == 5) {
            arena.sendMessage(ChatColor.AQUA + player.getName() + " HAS WON! Thanks for Playing");
            arena.reset(true);
            return;

        }
        player.sendMessage(ChatColor.GREEN + "+1 POINT!");
        points.replace(player.getUniqueId(), playerPoints);
    }
}
