package me.ulrich.raids.data;

import java.io.File;
import me.ulrich.raids.UltimateRaids;

/**
 * Base class for compatibility/provider extensions loaded from
 * {@code plugins/UltimateRaids/extensions}.
 */
public abstract class RaidExtension {
    private UltimateRaids plugin;
    private ExtensionInfo info;
    private File dataFolder;
    private ComponentState state = ComponentState.DISCOVERED;

    /** Internal lifecycle hook used by the UltimateRaids loader. */
    public final void init(UltimateRaids plugin, ExtensionInfo info, File dataFolder) {
        this.plugin = plugin;
        this.info = info;
        this.dataFolder = dataFolder;
    }

    /** Returns the public UltimateRaids facade. */
    public final UltimateRaids getRaidCore() { return plugin; }

    /** Returns metadata declared in {@code extension.yml}. */
    public final ExtensionInfo getInfo() { return info; }

    /** Returns the private data directory assigned to this extension. */
    public final File getDataFolder() { return dataFolder; }

    /** Returns the current lifecycle state. */
    public final ComponentState getState() { return state; }

    /** Internal lifecycle state setter used by the loader. */
    public final void setState(ComponentState state) { this.state = state; }

    /** Called after the extension class has been created but before enable. */
    public void onLoad() { }

    /** Called when the extension is enabled. */
    public abstract void onEnable();

    /** Called when the extension is disabled. */
    public abstract void onDisable();
}
