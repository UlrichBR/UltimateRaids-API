package me.ulrich.raids.api;

import java.util.Optional;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/** Safe canonical entry point for the running RaidWeaver API. */
public final class RaidWeaverProvider {

    private RaidWeaverProvider() {
    }

    public static Optional<RaidWeaverAPI> getOptional() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("RaidWeaver");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("UltimateRaids");
        }
        if (plugin == null || !plugin.isEnabled() || !(plugin instanceof RaidWeaverAPI)) {
            return Optional.empty();
        }
        return Optional.of((RaidWeaverAPI) plugin);
    }

    public static RaidWeaverAPI get() {
        return getOptional().orElseThrow(() ->
                new IllegalStateException("RaidWeaver is not installed, enabled, or does not expose the public API."));
    }

    public static boolean isAvailable() {
        return getOptional().isPresent();
    }
}
