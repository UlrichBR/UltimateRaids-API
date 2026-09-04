package me.ulrich.raids.api.model;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.ulrich.raids.api.type.RaidState;
import org.bukkit.Location;

/** Read-only runtime view for one concrete raid execution. */
public interface RaidInstanceView {
    UUID getId();
    RaidDefinitionView getDefinition();
    RaidState getState();

    /** Implementations must return a defensive copy. */
    Location getOrigin();

    Instant getCreatedAt();
    Optional<Instant> getStartedAt();
    Optional<Instant> getCompletedAt();

    Set<UUID> getParticipants();
    int getStageIndex();
    Optional<RaidStageView> getCurrentStage();
    Map<UUID, RaidContributionView> getContributions();
    Optional<String> getStopReason();

    default boolean contains(UUID playerId) {
        return playerId != null && getParticipants().contains(playerId);
    }
}
