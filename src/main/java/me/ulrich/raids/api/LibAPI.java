package me.ulrich.raids.api;

import org.bukkit.entity.Player;

/** Small stable utility surface useful to addons/extensions. */
public interface LibAPI {
    String getPluginTag();
    String getLanguage();
    String getTimeZone();
    void playSound(Player player, String specification);
}
