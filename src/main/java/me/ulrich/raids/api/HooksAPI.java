package me.ulrich.raids.api;

import java.util.Optional;
import org.bukkit.plugin.Plugin;

/** Safe lookup API for optional Bukkit plugin integrations. */
public interface HooksAPI {
    boolean isPluginEnabled(String pluginName);
    Optional<Plugin> getPlugin(String pluginName);
    Optional<String> getPluginVersion(String pluginName);
}
