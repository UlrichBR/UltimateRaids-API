package me.ulrich.raids.api;

/** Root public contract implemented by the UltimateRaids plugin. */
public interface UltimateRaidsAPI {

    /** Semantic version of this public API contract. */
    String API_VERSION = "1.0.0";

    /** Running UltimateRaids plugin version. */
    String getPluginVersion();

    /** Public raid operations and read-only runtime views. */
    RaidAPI getRaidAPI();

    default String getApiVersion() {
        return API_VERSION;
    }
}
