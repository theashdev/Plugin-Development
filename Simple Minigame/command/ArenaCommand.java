package com.ash.minigames.command;

import com.ash.minigames.GameState;
import com.ash.minigames.Minigame;
import com.ash.minigames.instance.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommand implements CommandExecutor {
    private Minigame minigame;

    public ArenaCommand(Minigame minigame) {
        this.minigame = minigame;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {




        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 1 && strings[0].equalsIgnoreCase("list")) {
                player.sendMessage(ChatColor.GREEN + "These are the available arenas:");
                for (Arena arena : minigame.getArenaManager().getArenas()) {
                    player.sendMessage(ChatColor.GREEN + "-" + arena.getId() + "(" + arena.getState().name() + ")");
                }

            } else if (strings.length == 1 && strings[0].equalsIgnoreCase("leave")) {
                Arena arena = minigame.getArenaManager().getArena(player);
                if (arena != null) {
                    player.sendMessage(ChatColor.RED +"You have left the Arena");
                    arena.removePlayer(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You are not in a Arena");
                }
            } else if (strings.length == 2 && strings[0].equalsIgnoreCase("join")) {
                if(minigame.getArenaManager().getArena(player) != null) {
                    player.sendMessage(ChatColor.RED + "You are Already in an Arena!");
                    return false;
                }

                int id;
                try{
                    id = Integer.parseInt(strings[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Please enter a valid arena ID!");
                    return false;
                }

                if (id >= 0 && id < minigame.getArenaManager().getArenas().size()) {
                    Arena arena = minigame.getArenaManager().getArena(id);
                    if (arena.getState() == GameState.RECRUITING || arena.getState() == GameState.COUNTDOWN) {
                        player.sendMessage(ChatColor.GREEN + "You are now Playing in Arena" + id + ".");
                        arena.addPlayer(player);
                    } else {
                        player.sendMessage(ChatColor.RED + "You cannot join this Arena!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Please enter a valid arena ID!");
                }



            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
                player.sendMessage(ChatColor.RED + "- /arena list");
                player.sendMessage(ChatColor.RED + "- /arena leave");
                player.sendMessage(ChatColor.RED + "- /arena join <id>");
            }
        }

        return false;
    }
}
