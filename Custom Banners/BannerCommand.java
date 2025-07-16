package com.ash.testing;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class BannerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack item = new ItemStack(Material.WHITE_BANNER);
            BannerMeta meta = (BannerMeta) item.getItemMeta();

            List<Pattern> patterns = new ArrayList<>();
            patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_RIGHT));
            patterns.add(new Pattern(DyeColor.YELLOW, PatternType.BORDER));

            meta.setPatterns(patterns);
            item.setItemMeta(meta);

            player.getInventory().addItem(item);
            player.sendMessage("§aYou received a custom banner!");
            return true;
        }

        sender.sendMessage("This command can only be used by players.");
        return true;
    }
}
