package me.ulrich.raids.data;

import java.util.List;

/** Immutable metadata loaded from an extension's {@code extension.yml}. */
public record ExtensionInfo(String name, String main, String version, String author,
                            String minVersion, List<String> depend, List<String> softDepend) {
}
