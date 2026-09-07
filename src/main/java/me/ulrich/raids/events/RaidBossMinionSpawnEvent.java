package me.ulrich.raids.events;

import java.util.List;
import java.util.UUID;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

/**
 * Fired after a boss successfully summons one or more tracked minions.
 *
 * <p>Only stable IDs are exposed. Boss/minion runtime handles and internal
 * definition classes are intentionally not part of the event contract.</p>
 */
public final class RaidBossMinionSpawnEvent extends RaidEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String bossId;
    private final String minionId;
    private final List<UUID> minionEntityIds;

    public RaidBossMinionSpawnEvent(
            RaidInstanceView instance,
            String bossId,
            String minionId,
            List<UUID> minionEntityIds
    ) {
        super(instance);
        this.bossId = bossId == null ? "" : bossId;
        this.minionId = minionId == null ? "" : minionId;
        this.minionEntityIds = List.copyOf(minionEntityIds == null ? List.of() : minionEntityIds);
    }

    public String getBossId() {
        return bossId;
    }

    public String getMinionId() {
        return minionId;
    }

    public List<UUID> getMinionEntityIds() {
        return minionEntityIds;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
