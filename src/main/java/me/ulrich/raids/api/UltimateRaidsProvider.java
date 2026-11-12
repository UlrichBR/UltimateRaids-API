package me.ulrich.raids.api;

import java.util.Optional;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Legacy provider retained for integrations compiled before the RaidWeaver rebrand.
 *
 * <p>External plugins should declare {@code depend: [UltimateRaids]} or an appropriate
 * soft dependency before accessing the provider.</p>
 */
@Deprecated(forRemoval = false)
public final class UltimateRaidsProvider {

    private UltimateRaidsProvider() {
    }

    public static Optional<UltimateRaidsAPI> getOptional() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("RaidWeaver");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("UltimateRaids");
        }
        if (plugin == null || !plugin.isEnabled() || !(plugin instanceof UltimateRaidsAPI)) {
            return Optional.empty();
        }
        return Optional.of((UltimateRaidsAPI) plugin);
    }

    public static UltimateRaidsAPI get() {
        return getOptional().orElseThrow(() ->
                new IllegalStateException("RaidWeaver is not installed, enabled, or does not expose the public API."));
    }

    public static boolean isAvailable() {
        return getOptional().isPresent();
    }
}
