package me.ulrich.raids.data;

import java.io.File;
import java.util.Optional;
import me.ulrich.raids.UltimateRaids;
import me.ulrich.raids.interfaces.BorderImplement;
import me.ulrich.raids.interfaces.EconomyImplement;
import me.ulrich.raids.interfaces.EntityImplement;
import me.ulrich.raids.interfaces.GroupImplement;
import me.ulrich.raids.interfaces.ItemParseImplement;
import me.ulrich.raids.interfaces.RaidActionImplement;
import me.ulrich.raids.interfaces.RaidObjectiveImplement;
import me.ulrich.raids.interfaces.RaidRequirementImplement;
import me.ulrich.raids.interfaces.RaidRewardImplement;
import me.ulrich.raids.interfaces.SchematicImplement;

/**
 * Base class for compatibility/provider extensions loaded from
 * {@code plugins/UltimateRaids/extensions}.
 */
public abstract class RaidExtension {
    private UltimateRaids plugin;
    private ExtensionInfo info;
    private File dataFolder;
    private ComponentState state = ComponentState.DISCOVERED;
    private final ComponentRegistrationTracker registrations = new ComponentRegistrationTracker();

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

    /**
     * Internal lifecycle state setter used by the loader.
     * Owned registrations are automatically released when the component is
     * disabled or fails, preventing references to its classloader from leaking.
     */
    public final void setState(ComponentState state) {
        this.state = state;
        if (state == ComponentState.DISABLED || state == ComponentState.FAILED) {
            unregisterOwnedRegistrations();
        }
    }

    /** Registers an item provider owned by this extension. */
    public final Optional<ItemParseImplement> registerItem(ItemParseImplement implementation) {
        Optional<ItemParseImplement> previous = requireCore().getIntegrationAPI().registerItem(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers an entity provider owned by this extension. */
    public final Optional<EntityImplement> registerEntity(EntityImplement implementation) {
        Optional<EntityImplement> previous = requireCore().getIntegrationAPI().registerEntity(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers a group provider owned by this extension. */
    public final Optional<GroupImplement> registerGroup(GroupImplement implementation) {
        Optional<GroupImplement> previous = requireCore().getIntegrationAPI().registerGroup(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers a border provider owned by this extension. */
    public final Optional<BorderImplement> registerBorder(BorderImplement implementation) {
        Optional<BorderImplement> previous = requireCore().getIntegrationAPI().registerBorder(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers an economy provider owned by this extension. */
    public final Optional<EconomyImplement> registerEconomy(EconomyImplement implementation) {
        Optional<EconomyImplement> previous = requireCore().getIntegrationAPI().registerEconomy(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers a schematic provider owned by this extension. */
    public final Optional<SchematicImplement> registerSchematic(SchematicImplement implementation) {
        Optional<SchematicImplement> previous = requireCore().getIntegrationAPI().registerSchematic(implementation);
        registrations.track(implementation);
        return previous;
    }

    /** Registers a custom action owned by this extension. */
    public final void registerAction(RaidActionImplement implementation) {
        requireCore().getRegistryAPI().registerAction(implementation);
        registrations.track(implementation);
    }

    /** Registers a custom reward owned by this extension. */
    public final void registerReward(RaidRewardImplement implementation) {
        requireCore().getRegistryAPI().registerReward(implementation);
        registrations.track(implementation);
    }

    /** Registers a custom objective owned by this extension. */
    public final void registerObjective(RaidObjectiveImplement implementation) {
        requireCore().getRegistryAPI().registerObjective(implementation);
        registrations.track(implementation);
    }

    /** Registers a custom requirement owned by this extension. */
    public final void registerRequirement(RaidRequirementImplement implementation) {
        requireCore().getRegistryAPI().registerRequirement(implementation);
        registrations.track(implementation);
    }

    /**
     * Removes all registrations still owned by this extension.
     * The loader may call this explicitly; it is also invoked automatically
     * when {@link #setState(ComponentState)} receives DISABLED or FAILED.
     */
    public final void unregisterOwnedRegistrations() {
        registrations.cleanup(plugin);
    }

    private UltimateRaids requireCore() {
        if (plugin == null) {
            throw new IllegalStateException("Extension has not been initialized by UltimateRaids");
        }
        return plugin;
    }

    /** Called after the extension class has been created but before enable. */
    public void onLoad() { }

    /** Called when the extension is enabled. */
    public abstract void onEnable();

    /** Called when the extension is disabled. */
    public abstract void onDisable();
}
