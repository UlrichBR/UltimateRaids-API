package me.ulrich.raids.interfaces;

import me.ulrich.raids.api.AddonAPI;
import me.ulrich.raids.api.CommandAPI;
import me.ulrich.raids.api.ExtensionAPI;
import me.ulrich.raids.api.GuiAPI;
import me.ulrich.raids.api.HooksAPI;
import me.ulrich.raids.api.IntegrationAPI;
import me.ulrich.raids.api.LibAPI;
import me.ulrich.raids.api.RaidAPI;
import me.ulrich.raids.api.RegistryAPI;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Public root contract exposed by UltimateRaids.
 *
 * <p>This interface intentionally exposes API contracts only. Internal managers,
 * storage implementations and runtime engine classes are not part of the public API.</p>
 */
public interface URaids {

    /** Returns the running Bukkit plugin instance. */
    JavaPlugin getPlugin();

    /** Returns public raid operations and runtime views. */
    RaidAPI getRaidAPI();

    /** Returns the provider/integration registry. */
    IntegrationAPI getIntegrationAPI();

    /** Returns extensible raid processor registries. */
    RegistryAPI getRegistryAPI();

    /** Returns loaded feature addon information. */
    AddonAPI getAddonAPI();

    /** Returns loaded compatibility extension information. */
    ExtensionAPI getExtensionAPI();

    /** Returns public command registration helpers. */
    CommandAPI getCommandAPI();

    /** Returns safe GUI entry points. */
    GuiAPI getGuiAPI();

    /** Returns installed-plugin/hook lookup helpers. */
    HooksAPI getHooksAPI();

    /** Returns small shared utility functions intended for integrations. */
    LibAPI getLibAPI();

    /** Returns the configured language id. */
    String getLanguage();

    /** Returns the configured server timezone id. */
    String getTimeZone();

    /** Returns the configured UltimateRaids tag/prefix. */
    String getTag();
}
