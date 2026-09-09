package me.ulrich.raids.interfaces;

import java.util.List;
import java.util.Optional;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * External region/protection provider contract.
 *
 * <p>The core may use {@link #canExecuteRaid(Player, String, Location)} during
 * admission checks. Region extensions may also be consumed directly by addons
 * that only need region/world discovery.</p>
 */
public interface RegionImplement {
    String getId();

    /** Returns all region ids that contain the location. */
    List<String> getRegions(Location location);

    /** Returns all configured region ids in a world. */
    List<String> getWorldRegions(World world);

    default boolean hasRegion(String regionId, Location location) {
        if (regionId == null || regionId.isBlank() || location == null) return false;
        return getRegions(location).stream().anyMatch(value -> value.equalsIgnoreCase(regionId));
    }

    /**
     * Optional provider-specific execution policy.
     *
     * <p>Returning false blocks normal player admission for the raid at the
     * supplied source location. Providers that only expose region discovery can
     * leave the default implementation.</p>
     */
    default boolean canExecuteRaid(Player player, String raidId, Location source) {
        return true;
    }

    /** Message returned when {@link #canExecuteRaid(Player, String, Location)} denies access. */
    default String getExecutionDenyMessage(Player player, String raidId, Location source) {
        return "This raid cannot be started from this region or world.";
    }

    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
