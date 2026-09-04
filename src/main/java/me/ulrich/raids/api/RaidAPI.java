package me.ulrich.raids.api;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.raids.api.model.RaidContributionView;
import me.ulrich.raids.api.model.RaidDefinitionView;
import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidLobbyView;
import me.ulrich.raids.api.model.RaidStageView;
import me.ulrich.raids.api.model.RaidValidationReport;
import me.ulrich.raids.api.model.RaidVoteView;
import me.ulrich.raids.api.result.RaidAccessResult;
import me.ulrich.raids.api.result.RaidQueueResult;
import me.ulrich.raids.api.result.RaidStartResult;
import me.ulrich.raids.api.result.RaidVoteResult;
import me.ulrich.raids.api.type.ParticipantState;
import me.ulrich.raids.api.type.RaidStartMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Stable public operations for UltimateRaids.
 *
 * <p>All returned raid/lobby/instance/stage objects are read-only views. External plugins
 * must use these methods instead of holding or mutating UltimateRaids internal managers.</p>
 */
public interface RaidAPI {

    Optional<RaidDefinitionView> getRaid(String raidId);

    Collection<RaidDefinitionView> getRaids();

    RaidValidationReport validateRaid(String raidId);

    Collection<RaidInstanceView> getActiveRaids();

    Optional<RaidInstanceView> getInstance(UUID instanceId);

    Optional<RaidInstanceView> getInstance(Player player);

    Optional<RaidStageView> getCurrentStage(UUID instanceId);

    Optional<RaidStageView> getCurrentStage(Player player);

    Optional<RaidLobbyView> getLobby(Player player);

    Collection<RaidLobbyView> getLobbies();

    Optional<RaidContributionView> getContribution(UUID instanceId, UUID playerId);

    RaidStartResult startRaid(String raidId);

    RaidStartResult startRaid(String raidId, Location origin);

    RaidStartResult startRaid(String raidId, Location origin, RaidStartMode mode);

    boolean stopRaid(UUID instanceId, String reason);

    RaidAccessResult canJoin(Player player, UUID instanceId);

    RaidAccessResult joinRaid(Player player, UUID instanceId);

    boolean leaveRaid(Player player);

    RaidQueueResult queueRaid(Player player, String raidId, Location origin);

    /** Generic queue hook intended for NPCs, signs and external integrations. */
    RaidQueueResult queueRaidFromTrigger(Player player, String raidId);

    boolean toggleReady(Player player);

    RaidVoteResult requestStartVote(Player player);

    RaidVoteResult voteStart(Player player, boolean yes);

    Optional<RaidVoteView> getVoteStatus(Player player);

    int getCompletions(UUID playerId, String raidId);

    int getLives(Player player);

    ParticipantState getParticipantState(Player player);

    boolean isInsideRaidArea(Player player);

    default boolean isInRaid(Player player) {
        return player != null && getInstance(player).isPresent();
    }

    default boolean isInLobby(Player player) {
        return player != null && getLobby(player).isPresent();
    }
}
