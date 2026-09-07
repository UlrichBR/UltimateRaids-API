package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;

/**
 * Fired after an entity has been registered as part of a raid.
 *
 * <p>This event deliberately exposes only public-safe metadata. Internal
 * runtime handles remain private to the Core.</p>
 */
public final class RaidEntitySpawnEvent extends RaidEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String raidEntityId;
    private final String provider;
    private final String type;
    private final boolean boss;
    private final Entity entity;

    public RaidEntitySpawnEvent(
            RaidInstanceView instance,
            String raidEntityId,
            String provider,
            String type,
            boolean boss,
            Entity entity
    ) {
        super(instance);
        this.raidEntityId = raidEntityId == null ? "" : raidEntityId;
        this.provider = provider == null ? "" : provider;
        this.type = type == null ? "" : type;
        this.boss = boss;
        this.entity = entity;
    }

    public String getRaidEntityId() {
        return raidEntityId;
    }

    public String getProvider() {
        return provider;
    }

    public String getType() {
        return type;
    }

    public boolean isBoss() {
        return boss;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
