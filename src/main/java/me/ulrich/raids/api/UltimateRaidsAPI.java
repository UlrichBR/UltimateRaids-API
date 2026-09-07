package me.ulrich.raids.api;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Root public contract implemented by the running UltimateRaids plugin.
 *
 * <p>This interface intentionally exposes only stable API contracts. Internal
 * managers and mutable raid runtime objects are not part of this surface.</p>
 */
public interface UltimateRaidsAPI {

    /** Semantic version of the public API surface. */
    String API_VERSION = "1.2.0";

    JavaPlugin getPlugin();

    RaidAPI getRaidAPI();
    IntegrationAPI getIntegrationAPI();
    RegistryAPI getRegistryAPI();
    AddonAPI getAddonAPI();
    ExtensionAPI getExtensionAPI();
    CommandAPI getCommandAPI();
    GuiAPI getGuiAPI();
    HooksAPI getHooksAPI();
    LibAPI getLibAPI();

    String getPluginVersion();
    String getLanguage();
    String getTimeZone();
    String getTag();

    default String getApiVersion() {
        return API_VERSION;
    }
}
