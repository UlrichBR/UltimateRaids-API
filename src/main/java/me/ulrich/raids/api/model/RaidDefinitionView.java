package me.ulrich.raids.api.model;

import java.util.List;
import java.util.Optional;
import me.ulrich.raids.api.type.EntryMode;
import me.ulrich.raids.api.type.EnvironmentMode;
import me.ulrich.raids.api.type.InstanceSource;
import me.ulrich.raids.api.type.LoadoutMode;
import me.ulrich.raids.api.type.ParticipationMode;
import me.ulrich.raids.api.type.ProgressionMode;

/**
 * Read-only public raid definition.
 *
 * <p>This is intentionally a summary and does not expose raw YAML or internal definition objects.</p>
 */
public interface RaidDefinitionView {
    String getId();
    String getName();
    String getDescription();
    boolean isEnabled();

    EntryMode getEntryMode();
    ParticipationMode getParticipationMode();
    EnvironmentMode getEnvironmentMode();
    Optional<InstanceSource> getInstanceSource();
    ProgressionMode getProgressionMode();

    String getGroupProvider();
    int getMinPlayers();
    int getMaxPlayers();
    int getMinGroups();
    int getMaxGroups();
    boolean isLateJoinAllowed();
    boolean isLeaderOnlyQueue();

    LoadoutMode getLoadoutMode();
    Optional<String> getKitId();

    List<RaidStageDefinitionView> getStages();

    default int getStageCount() {
        return getStages().size();
    }

    default boolean isMinigame() {
        return getEntryMode() == EntryMode.MINIGAME;
    }
}
