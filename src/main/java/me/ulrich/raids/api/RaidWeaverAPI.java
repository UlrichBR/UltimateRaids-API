package me.ulrich.raids.api;

/**
 * Canonical public API contract for RaidWeaver.
 *
 * <p>The historical {@link UltimateRaidsAPI} type remains the binary base so
 * integrations compiled before the rebrand keep working without a package migration.</p>
 */
public interface RaidWeaverAPI extends UltimateRaidsAPI {
}
