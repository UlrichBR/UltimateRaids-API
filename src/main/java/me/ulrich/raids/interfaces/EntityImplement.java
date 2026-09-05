package me.ulrich.raids.interfaces;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.raids.data.EntitySpawnRequest;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

/** External entity/mob provider contract. */
public interface EntityImplement {
    String getId();
    Optional<Entity> spawn(Location location, EntitySpawnRequest request);
    default void remove(Entity entity) { if (entity != null) entity.remove(); }
    default Optional<Entity> resolve(UUID uuid) { return Optional.empty(); }
    default boolean supportsSkills() { return false; }
    default boolean executeSkill(Entity entity, String skillId, Map<String, Object> options) { return false; }
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
