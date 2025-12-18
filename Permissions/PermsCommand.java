package com.ash.permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermsCommand implements CommandExecutor {

    private final HashMap<UUID, PermissionAttachment> perms = new HashMap<>();
    private final Main main;

    public PermsCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        PermissionAttachment attachment;

        if (!perms.containsKey(player.getUniqueId())) {
            attachment = player.addAttachment(main);
            perms.put(player.getUniqueId(), attachment);
        } else {
            attachment = perms.get(player.getUniqueId());
        }

        boolean hasPerm = attachment.getPermissions().getOrDefault("worldedit.help", false);

        if (hasPerm) {
            attachment.unsetPermission("worldedit.help");
            player.sendMessage("§cWorldEdit permission removed.");
        } else {
            attachment.setPermission("worldedit.help", true);
            player.sendMessage("§aWorldEdit permission added.");
        }

        return true;
    }
}
