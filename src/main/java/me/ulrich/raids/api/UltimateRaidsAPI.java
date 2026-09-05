package me.ulrich.raids.api;

import me.ulrich.raids.interfaces.URaids;

/** Root public contract implemented by the UltimateRaids plugin. */
public interface UltimateRaidsAPI extends URaids {

    /** Semantic version of the public API surface. */
    String API_VERSION = "1.0.0";

    /** Returns the running UltimateRaids plugin version. */
    String getPluginVersion();

    /** Returns the public API contract version. */
    default String getApiVersion() { return API_VERSION; }
}
