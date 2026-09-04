package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

public final class RaidCompleteEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();

    public RaidCompleteEvent(RaidInstanceView instance) {
        super(instance);
    }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
