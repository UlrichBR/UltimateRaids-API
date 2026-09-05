package me.ulrich.raids.api;

import java.util.Collection;
import java.util.Optional;
import me.ulrich.raids.data.AddonInfo;
import me.ulrich.raids.data.RaidAddon;

/** Read-only access to UltimateRaids feature addons. */
public interface AddonAPI {
    Optional<RaidAddon> getAddon(String name);
    Collection<RaidAddon> getAddons();
    Optional<AddonInfo> getAddonInfo(String name);
    boolean isAddonEnabled(String name);
}
