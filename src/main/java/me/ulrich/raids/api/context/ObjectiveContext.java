package me.ulrich.raids.api.context;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import me.ulrich.raids.data.ObjectiveData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/** Mutable objective-scoped runtime context exposed to custom objectives. */
public interface ObjectiveContext {
    RaidInstanceView getInstance();
    RaidStageView getStage();
    ObjectiveData getDefinition();
    int getProgress();
    int increment();
    int add(int amount);
    void setProgress(int amount);
    long getElapsedSeconds();
    Object data(String key);
    void data(String key, Object value);
    Set<UUID> players(String key);
    boolean isParticipant(UUID playerId);
    boolean isActiveParticipant(UUID playerId);
    List<Player> getActivePlayers();
    Collection<Entity> getStageEntities();
}
