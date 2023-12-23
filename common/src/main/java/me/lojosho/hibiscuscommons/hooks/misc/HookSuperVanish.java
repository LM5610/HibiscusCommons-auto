package me.lojosho.hibiscuscommons.hooks.misc;

import de.myzelyam.api.vanish.PlayerHideEvent;
import de.myzelyam.api.vanish.PlayerShowEvent;
import me.lojosho.hibiscuscommons.api.events.HibiscusPlayerUnVanishEvent;
import me.lojosho.hibiscuscommons.api.events.HibiscusPlayerVanishEvent;
import me.lojosho.hibiscuscommons.hooks.Hook;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.jetbrains.annotations.NotNull;

/**
 * A hook that integrates the plugin {@link de.myzelyam.api.vanish.VanishAPI Supervanish}
 *
 * @implSpec Supervanish and Premium Vanish both use the same api
 */
public class HookSuperVanish extends Hook {
    public HookSuperVanish() {
        super("SuperVanish");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerVanish(@NotNull PlayerHideEvent event) {
        HibiscusPlayerVanishEvent newEvent = new HibiscusPlayerVanishEvent(event.getPlayer());
        Bukkit.getPluginManager().callEvent(newEvent);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerShow(@NotNull PlayerShowEvent event) {
        HibiscusPlayerUnVanishEvent newEvent = new HibiscusPlayerUnVanishEvent(event.getPlayer());
        Bukkit.getPluginManager().callEvent(newEvent);
    }
}
