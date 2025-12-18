package com.ash.customRepies;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // Custom Stick
        ItemStack is = new ItemStack(Material.STICK);
        is.addUnsafeEnchantment(Enchantment.SHARPNESS, 69);

        ItemMeta isMeta = is.getItemMeta();
        isMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "KRAKEN KE ANDR KI BADI LAKDI");
        is.setItemMeta(isMeta);

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(this, "custom_stick"),
                is
        );

        recipe.shape(
                "SSS",
                "SSS",
                "SSS"
        );

        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
