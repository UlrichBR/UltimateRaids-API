package me.ulrich.raids.interfaces;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.raids.data.RaidGroup;
import org.bukkit.entity.Player;

/** External party/clan/group provider contract. */
public interface GroupImplement {
    String getId();
    Optional<RaidGroup> getGroup(Player player);
    Optional<RaidGroup> getGroup(UUID groupId);
    Collection<UUID> getMembers(RaidGroup group);
    default boolean isLeader(Player player, RaidGroup group) { return group.getLeader().map(player.getUniqueId()::equals).orElse(false); }
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
