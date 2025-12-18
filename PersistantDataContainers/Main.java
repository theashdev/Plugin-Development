package com.ash.persistentDataContainers;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.stream.events.Namespace;

public final class Main extends JavaPlugin {

    NamespacedKey key = new NamespacedKey(this, "surname");


    @Override
    public void onEnable() {
        Player player = Bukkit.getPlayer("Ash");
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(key, PersistentDataType.STRING, "king");

        if (player.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            String surname = player.getPersistentDataContainer().get(PersistentDataType.STRING);
        }
        
    }

}
