package com.ash.minigames.Listener;

import com.ash.minigames.GameState;
import com.ash.minigames.Minigame;
import com.ash.minigames.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GameListener implements Listener {

    private Minigame minigame;
    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());
        if (arena !=null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoint(e.getPlayer());
        }


    }
}
