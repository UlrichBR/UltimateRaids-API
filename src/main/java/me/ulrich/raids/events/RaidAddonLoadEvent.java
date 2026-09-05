package me.ulrich.raids.events;

import me.ulrich.raids.data.RaidAddon;
import org.bukkit.event.HandlerList;

/** Fired when an UltimateRaids addon reaches the load lifecycle phase. */
public final class RaidAddonLoadEvent extends RaidAddonEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    public RaidAddonLoadEvent(RaidAddon addon) { super(addon); }
    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
