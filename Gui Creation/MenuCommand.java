package com.ash.guiscreation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

       if (commandSender instanceof Player) {
           Player player = (Player) commandSender;

           Inventory inv = Bukkit.createInventory(player, 45 , ChatColor.RED.toString() + ChatColor.BOLD + "Tools Menu!");

           ItemStack teleport = new ItemStack(Material.ENDER_PEARL);
           ItemMeta teleportMeta = teleport.getItemMeta();
           teleportMeta.setDisplayName(ChatColor.BLUE + "Random Teleport");
           teleportMeta.setLore(Arrays.asList(ChatColor.GRAY + "Teleports to a Random Player"));
           teleport.setItemMeta(teleportMeta);
           inv.setItem(20, teleport);

           //KILL YOURSELF
           ItemStack kys = new ItemStack(Material.DIAMOND_SWORD);
           ItemMeta kysMeta = kys.getItemMeta();
           kysMeta.setDisplayName(ChatColor.RED + "Kill yourself");
           kysMeta.setLore(Arrays.asList(ChatColor.GRAY + "Kills you"));
           kys.setItemMeta(kysMeta);

           inv.setItem(22 , kys);
           // CLEAR INV

           ItemStack clear = new ItemStack(Material.BUCKET);
           ItemMeta clearMeta = clear.getItemMeta();
           clearMeta.setDisplayName(ChatColor.GOLD + "Clear Inventory");
           clearMeta.setLore(Arrays.asList(ChatColor.GRAY + "Clears your inv"));
           clear.setItemMeta(clearMeta);

           inv.setItem(24,clear);

           //CLOSE BUTTON
           ItemStack close = new ItemStack(Material.BUCKET);
           ItemMeta closeMeta = close.getItemMeta();
           closeMeta.setDisplayName(ChatColor.RED + "Close!");
           close.setItemMeta(closeMeta);

           inv.setItem(0, close);

           //FRAME
           ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
           for (int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,35,36,37,38,39,40,41,42,43,44}) {
               inv.setItem(i, frame);
           }



           player.openInventory(inv);
       }

        return false;
    }
}
