package me.ulrich.raids.events;

import me.ulrich.raids.data.AddonInfo;
import me.ulrich.raids.data.RaidAddon;
import org.bukkit.event.Event;

/** Base event for UltimateRaids addon lifecycle changes. */
public abstract class RaidAddonEvent extends Event {
    private final RaidAddon addon;
    protected RaidAddonEvent(RaidAddon addon) { this.addon = addon; }
    public RaidAddon getAddon() { return addon; }
    public AddonInfo getInfo() { return addon.getInfo(); }
}
