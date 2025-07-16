package com.ash.testing;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle(ChatColor.RED + "Crazy Book");
            meta.setAuthor(ChatColor.YELLOW + "Sigma Ash");
            meta.addPage(
                    ChatColor.GREEN + "Welcome to My book.\n" +
                            ChatColor.BLUE + "It has multiple pages.\n" +
                            ChatColor.GOLD + "Enjoy reading it!");
            book.setItemMeta(meta);

            player.getInventory().addItem(book);
        }
        return false;
    }
}
