package com.ash.forceSkin;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        setSkin(e.getPlayer());
    }

    private void setSkin(Player player) {
        EntityPlayer ep = ((CraftPlayer) player).getHandle();
        GameProfile gp = ep.getBukkitEntity().getProfile();
        PropertyMap pm = gp.getProperties();

        if (pm == null) return;

        Iterator<Property> it = pm.get("textures").iterator();
        if (it.hasNext()) {
            Property property = it.next();
            pm.remove("textures", property);
        }

        pm.put("textures", new Property(
                "textures",
                "ewogICJ0aW1lc3RhbXAiIDogMTc2NTkxODc1OTY1OCwKICAicHJvZmlsZUlkIiA6ICI0NTlhYTA1MmYxMTI0ZmFjYWQ3Y2Y4YjUwM2I2NzJiNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJIdXpoYW4iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWE1MzJkODc4YjA0NTE3NGIyNDUzYTE4YWUyZTU1YjE3MTljYmY5ODYyNmFmMDMwMzQ5MmQ0ZTkyZTMxMDBkOSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9",
                "HQEeBfUvaChW/q7jY56SZginK6TYapRV/FUriJlQrsZAoqJwzubBgSTd/KH7zB/rcjErMGv2ZBKKxEe1ihzlERRN8J7AzJpuN9SRtsWLt7xypgmW9hBiiCwChdi8yKRDn8b+vBoRe82XF/WvWbDZGbcCBXN7wOelI/kmzwy+q9SRfsC5RJdTdbCXjmNL9B1/qs5CuJ/8+cfS+BACebxcm80K5d6Ovwvc0VcAa27E4ZBPUKkWDI+EdCp3hZNVI7lU5M5YsltA6VcdowBT3ay4I7MrqhMCXHUf5fQvXqSJe6eAOfLMAEsE/ziROYyIA9NBbH5EXIB+mTTymCKrZ0E6lnNvHmAzyiJccYWBn7bRE1j9TAWP+eYq1hZPpwxe666zzpFfEL3HbG8LD+74Wt6uOBaO7FqMtdGWDIPr84RcURxUK//7EpL+N+OuMADvlyuKfd9LZoh/SbgDhndZ+4GpTTjz8x/6dDMacsZ9Tlr085TYA04rXT8bvzL44AkbJV7rF57fmXPey+fKLhtctHc99iWGbY5JfEu9TSmOcfeF/ef8Xjr9lI6AH/70pCKDHDYrPzAxS93R/RJ/LbYCQqSGcsuNuyTIJnSMN58RCE/1RmkYGQCp8YxvhOQ6SF0qQKsUmY1Bn4FtnhyxzFhEmC+4DZHFxlfVy4KUTyiILN0S0Tk="
        ));
    }
}
