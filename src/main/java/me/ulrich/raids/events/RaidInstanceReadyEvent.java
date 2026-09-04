package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

/** Fired when an INSTANCE arena is fully prepared and safe to enter. */
public final class RaidInstanceReadyEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final long preparationMillis;

    public RaidInstanceReadyEvent(RaidInstanceView instance, long preparationMillis) {
        super(instance);
        this.preparationMillis = Math.max(0L, preparationMillis);
    }

    public long getPreparationMillis() {
        return preparationMillis;
    }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
