package me.ulrich.raids.manager.utils;

import java.util.Map;

import me.ulrich.raids.UltimateRaids;

/**
 * Public compile-time facade for the UltimateRaids semantic color manager.
 *
 * <p>The runtime implementation is supplied by the UltimateRaids Core.</p>
 */
public final class ColorManager {

    public ColorManager(UltimateRaids plugin) {
        throw runtimeOnly();
    }

    public synchronized void reload() {
        throw runtimeOnly();
    }

    public String parse(String input) {
        throw runtimeOnly();
    }

    public String get(String id) {
        throw runtimeOnly();
    }

    public Map<String, String> snapshot() {
        throw runtimeOnly();
    }

    private static UnsupportedOperationException runtimeOnly() {
        return new UnsupportedOperationException("ColorManager runtime implementation is supplied by UltimateRaids Core");
    }
}
