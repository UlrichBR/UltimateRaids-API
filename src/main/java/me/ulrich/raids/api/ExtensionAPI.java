package me.ulrich.raids.api;

import java.util.Collection;
import java.util.Optional;
import me.ulrich.raids.data.ExtensionInfo;
import me.ulrich.raids.data.RaidExtension;

/** Read-only access to loaded compatibility extensions. */
public interface ExtensionAPI {
    Optional<RaidExtension> getExtension(String name);
    Collection<RaidExtension> getExtensions();
    Optional<ExtensionInfo> getExtensionInfo(String name);
    boolean isExtensionEnabled(String name);
}
