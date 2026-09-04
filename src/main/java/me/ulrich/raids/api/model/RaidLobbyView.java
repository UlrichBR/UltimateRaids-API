package me.ulrich.raids.api.model;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.ulrich.raids.api.type.RaidLobbyState;
import org.bukkit.Location;

/** Read-only matchmaking lobby view. */
public interface RaidLobbyView {
    UUID getId();
    RaidDefinitionView getDefinition();
    RaidLobbyState getState();

    /** Implementations must return a defensive copy. */
    Location getOrigin();

    Instant getCreatedAt();
    long getAgeSeconds();

    Set<UUID> getPlayers();
    Set<UUID> getReadyPlayers();
    Collection<RaidGroupView> getGroups();

    int getCountdownRemaining();
    Optional<RaidVoteView> getVote();

    default boolean contains(UUID playerId) {
        return playerId != null && getPlayers().contains(playerId);
    }
}
