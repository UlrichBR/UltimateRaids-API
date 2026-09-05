package me.ulrich.raids.events;

import me.ulrich.raids.data.RaidExtension;
import org.bukkit.event.HandlerList;

/** Fired when an UltimateRaids extension reaches the load lifecycle phase. */
public final class RaidExtensionLoadEvent extends RaidExtensionEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    public RaidExtensionLoadEvent(RaidExtension extension) { super(extension); }
    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
