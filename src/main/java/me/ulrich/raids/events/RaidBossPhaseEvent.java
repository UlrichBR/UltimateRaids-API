package me.ulrich.raids.events;

import java.util.UUID;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

/** Fired when a raid boss enters a configured phase. */
public final class RaidBossPhaseEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final String bossId;
    private final String phaseId;
    private final UUID entityId;

    public RaidBossPhaseEvent(RaidInstanceView instance, String bossId, String phaseId, UUID entityId) {
        super(instance);
        this.bossId = bossId == null ? "" : bossId;
        this.phaseId = phaseId == null ? "" : phaseId;
        this.entityId = entityId;
    }

    public String getBossId() { return bossId; }
    public String getPhaseId() { return phaseId; }
    public UUID getEntityId() { return entityId; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
