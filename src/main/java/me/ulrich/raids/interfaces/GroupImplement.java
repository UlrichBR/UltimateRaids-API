package me.ulrich.raids.interfaces;

import java.util.Collection;
import java.util.Optional;
import java.util.Objects;
import java.util.UUID;
import me.ulrich.raids.api.type.GroupRelation;
import me.ulrich.raids.data.RaidGroup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/** External party/clan/group provider contract. */
public interface GroupImplement {
    String getId();

    /** Resolves the group of an online player. */
    Optional<RaidGroup> getGroup(Player player);

    /**
     * Legacy group-id lookup kept for source/binary migration.
     *
     * @deprecated use {@link #getGroupById(UUID)}.
     */
    @Deprecated(forRemoval = true)
    Optional<RaidGroup> getGroup(UUID groupId);

    /**
     * Resolves a group by its provider-specific persistent id.
     *
     * <p>The default implementation delegates to the legacy UUID lookup so
     * existing providers remain compatible.</p>
     */
    default Optional<RaidGroup> getGroupById(UUID groupId) {
        return getGroup(groupId);
    }

    /**
     * Resolves the group of a player UUID.
     *
     * <p>Providers with offline/persistent storage should override this method.
     * The default implementation only resolves players that are currently online.</p>
     */
    default Optional<RaidGroup> getGroupByPlayer(UUID playerId) {
        if (playerId == null) {
            return Optional.empty();
        }
        Player player = Bukkit.getPlayer(playerId);
        return player == null ? Optional.empty() : getGroup(player);
    }

    Collection<UUID> getMembers(RaidGroup group);

    default boolean isLeader(Player player, RaidGroup group) {
        return player != null && group != null
                && group.getLeader().map(player.getUniqueId()::equals).orElse(false);
    }

    /**
     * Returns the relationship between two groups.
     * Providers that support alliances/rivalries should override this method.
     */
    default GroupRelation getRelation(RaidGroup first, RaidGroup second) {
        if (first == null || second == null) {
            return GroupRelation.NEUTRAL;
        }
        return Objects.equals(first.getId(), second.getId()) ? GroupRelation.SAME : GroupRelation.NEUTRAL;
    }

    default boolean areAllied(RaidGroup first, RaidGroup second) {
        GroupRelation relation = getRelation(first, second);
        return relation == GroupRelation.SAME || relation == GroupRelation.ALLY;
    }

    default boolean areRivals(RaidGroup first, RaidGroup second) {
        return getRelation(first, second) == GroupRelation.RIVAL;
    }

    default Optional<String> getPluginVersion() {
        return Optional.empty();
    }
}
