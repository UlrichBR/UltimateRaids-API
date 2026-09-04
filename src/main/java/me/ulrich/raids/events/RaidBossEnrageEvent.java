package me.ulrich.raids.events;

import java.util.UUID;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

/** Fired once when a raid boss enters its configured enrage state. */
public final class RaidBossEnrageEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final String bossId;
    private final UUID entityId;

    public RaidBossEnrageEvent(RaidInstanceView instance, String bossId, UUID entityId) {
        super(instance);
        this.bossId = bossId == null ? "" : bossId;
        this.entityId = entityId;
    }

    public String getBossId() { return bossId; }
    public UUID getEntityId() { return entityId; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
