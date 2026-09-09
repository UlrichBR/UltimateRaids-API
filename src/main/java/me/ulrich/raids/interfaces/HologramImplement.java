package me.ulrich.raids.interfaces;

import java.util.List;
import java.util.Optional;
import org.bukkit.Location;

/** External hologram provider contract used by extensions and visual addons. */
public interface HologramImplement {
    String getId();

    /** Creates or replaces a hologram with the supplied id. */
    boolean createHologram(String id, Location location, List<String> lines);

    /** Updates text while keeping the current location when possible. */
    boolean updateHologram(String id, List<String> lines);

    /** Moves an existing hologram. Implementations may recreate it internally. */
    boolean moveHologram(String id, Location location);

    boolean removeHologram(String id);
    boolean hasHologram(String id);

    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
