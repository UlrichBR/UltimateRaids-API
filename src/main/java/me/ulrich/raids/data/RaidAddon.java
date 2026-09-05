package me.ulrich.raids.data;

import java.io.File;
import me.ulrich.raids.UltimateRaids;

/**
 * Base class for feature addons loaded from {@code plugins/UltimateRaids/addons}.
 *
 * <p>Addons are managed by UltimateRaids and are not required to be Bukkit plugins.</p>
 */
public abstract class RaidAddon {
    private UltimateRaids plugin;
    private AddonInfo info;
    private File dataFolder;
    private ComponentState state = ComponentState.DISCOVERED;

    /** Internal lifecycle hook used by the UltimateRaids loader. */
    public final void init(UltimateRaids plugin, AddonInfo info, File dataFolder) {
        this.plugin = plugin;
        this.info = info;
        this.dataFolder = dataFolder;
    }

    /** Returns the public UltimateRaids facade. */
    public final UltimateRaids getRaidCore() { return plugin; }

    /** Returns metadata declared in {@code addon.yml}. */
    public final AddonInfo getInfo() { return info; }

    /** Returns the private data directory assigned to this addon. */
    public final File getDataFolder() { return dataFolder; }

    /** Returns the current lifecycle state. */
    public final ComponentState getState() { return state; }

    /** Internal lifecycle state setter used by the loader. */
    public final void setState(ComponentState state) { this.state = state; }

    /** Called after the addon class has been created but before enable. */
    public void onLoad() { }

    /** Called when the addon is enabled. */
    public abstract void onEnable();

    /** Called when the addon is disabled. */
    public abstract void onDisable();
}
