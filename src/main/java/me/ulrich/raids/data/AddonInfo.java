package me.ulrich.raids.data;

import java.util.List;

/** Immutable metadata loaded from an addon's {@code addon.yml}. */
public record AddonInfo(String name, String main, String version, String author,
                        String minVersion, List<String> depend, List<String> softDepend) {

    public AddonInfo {
        depend = depend == null ? List.of() : List.copyOf(depend);
        softDepend = softDepend == null ? List.of() : List.copyOf(softDepend);
    }
}
