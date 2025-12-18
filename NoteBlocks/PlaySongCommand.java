package com.ash.noteBlocks;

import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class PlaySongCommand implements CommandExecutor {


    private Main main;

    public PlaySongCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            RadioSongPlayer rsp = new RadioSongPlayer(NBSDecoder.parse(new File(main.getDataFolder(), "milliondollarbaby.nbs")));
            rsp.addPlayer(player);
            rsp.setPlaying(true);

        }

        return false;
    }
}
