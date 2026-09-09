package me.ulrich.raids.interfaces;

import java.util.Map;
import java.util.Optional;
import org.bukkit.Location;

/** External web-map/area-marker provider contract. */
public interface MapImplement {
    String getId();

    /** Creates or replaces a rectangular raid area marker. */
    boolean createArea(String markerId,
                       String label,
                       Location first,
                       Location second,
                       Map<String, Object> options);

    /** Removes an area marker owned by UltimateRaids. */
    boolean removeArea(String markerId);

    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
