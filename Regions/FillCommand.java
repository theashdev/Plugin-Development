package com.ash.regions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FillCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        World world = player.getWorld(); // same world as selection

        Location pos1 = new Location(world, -56, 67, 328);
        Location pos2 = new Location(world, -61, 70, 337);

        Cuboid cuboid = new Cuboid(pos1, pos2);
        for (Block block : cuboid.getBlocks()) {
            block.setType(Material.LIME_TERRACOTTA);
        }

        player.sendMessage("Cuboid created between Pos1 and Pos2!");

        return false;
    }
}
