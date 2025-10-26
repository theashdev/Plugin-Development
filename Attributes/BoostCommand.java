package com.ash.attributes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.EquipmentSlotGroup;

public class BoostCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack item = player.getInventory().getItemInMainHand();
            if (item != null && item.getType() != Material.AIR) {
                ItemMeta meta = item.getItemMeta();
                // Using the recommended constructor with NamespacedKey and EquipmentSlotGroup
                AttributeModifier modifier = new AttributeModifier(
                        new NamespacedKey("ash", "boost_attack_damage"), // Use your plugin namespace
                        100, // Use '100' if you want "100 attack damage"
                        Operation.ADD_NUMBER,
                        EquipmentSlotGroup.HAND // HAND for main hand slot group
                );
                meta.addAttributeModifier(Attribute.ATTACK_DAMAGE, modifier);
                item.setItemMeta(meta);
                player.sendMessage("Your item has been given 100 attack damage");
            }
        }
        return true;
    }
}
