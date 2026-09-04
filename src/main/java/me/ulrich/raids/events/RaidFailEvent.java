package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.HandlerList;

public final class RaidFailEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final String reason;

    public RaidFailEvent(RaidInstanceView instance, String reason) {
        super(instance);
        this.reason = reason == null ? "" : reason;
    }

    public String getReason() {
        return reason;
    }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
