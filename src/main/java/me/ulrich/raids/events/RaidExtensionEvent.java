package me.ulrich.raids.events;

import me.ulrich.raids.data.ExtensionInfo;
import me.ulrich.raids.data.RaidExtension;
import org.bukkit.event.Event;

/** Base event for UltimateRaids extension lifecycle changes. */
public abstract class RaidExtensionEvent extends Event {
    private final RaidExtension extension;
    protected RaidExtensionEvent(RaidExtension extension) { this.extension = extension; }
    public RaidExtension getExtension() { return extension; }
    public ExtensionInfo getInfo() { return extension.getInfo(); }
}
