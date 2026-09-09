package me.ulrich.raids.data;

import java.util.LinkedHashMap;
import java.util.Map;
import me.ulrich.raids.UltimateRaids;
import me.ulrich.raids.api.IntegrationAPI;
import me.ulrich.raids.api.RegistryAPI;
import me.ulrich.raids.interfaces.BorderImplement;
import me.ulrich.raids.interfaces.EconomyImplement;
import me.ulrich.raids.interfaces.EntityImplement;
import me.ulrich.raids.interfaces.GroupImplement;
import me.ulrich.raids.interfaces.ItemParseImplement;
import me.ulrich.raids.interfaces.HologramImplement;
import me.ulrich.raids.interfaces.MapImplement;
import me.ulrich.raids.interfaces.RegionImplement;
import me.ulrich.raids.interfaces.ScoreboardImplement;
import me.ulrich.raids.interfaces.PlayerVisualImplement;
import me.ulrich.raids.interfaces.RaidActionImplement;
import me.ulrich.raids.interfaces.RaidObjectiveImplement;
import me.ulrich.raids.interfaces.RaidRequirementImplement;
import me.ulrich.raids.interfaces.RaidRewardImplement;
import me.ulrich.raids.interfaces.SchematicImplement;

/** Internal ownership tracker used by {@link RaidAddon} and {@link RaidExtension}. */
final class ComponentRegistrationTracker {

    private final Map<String, ItemParseImplement> items = new LinkedHashMap<>();
    private final Map<String, EntityImplement> entities = new LinkedHashMap<>();
    private final Map<String, GroupImplement> groups = new LinkedHashMap<>();
    private final Map<String, BorderImplement> borders = new LinkedHashMap<>();
    private final Map<String, EconomyImplement> economies = new LinkedHashMap<>();
    private final Map<String, SchematicImplement> schematics = new LinkedHashMap<>();
    private final Map<String, PlayerVisualImplement> visuals = new LinkedHashMap<>();
    private final Map<String, RegionImplement> regions = new LinkedHashMap<>();
    private final Map<String, ScoreboardImplement> scoreboards = new LinkedHashMap<>();
    private final Map<String, MapImplement> maps = new LinkedHashMap<>();
    private final Map<String, HologramImplement> holograms = new LinkedHashMap<>();

    private final Map<String, RaidActionImplement> actions = new LinkedHashMap<>();
    private final Map<String, RaidRewardImplement> rewards = new LinkedHashMap<>();
    private final Map<String, RaidObjectiveImplement> objectives = new LinkedHashMap<>();
    private final Map<String, RaidRequirementImplement> requirements = new LinkedHashMap<>();

    synchronized void track(ItemParseImplement implementation) {
        if (implementation != null) items.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(EntityImplement implementation) {
        if (implementation != null) entities.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(GroupImplement implementation) {
        if (implementation != null) groups.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(BorderImplement implementation) {
        if (implementation != null) borders.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(EconomyImplement implementation) {
        if (implementation != null) economies.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(SchematicImplement implementation) {
        if (implementation != null) schematics.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(PlayerVisualImplement implementation) {
        if (implementation != null) visuals.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(RegionImplement implementation) {
        if (implementation != null) regions.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(ScoreboardImplement implementation) {
        if (implementation != null) scoreboards.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(MapImplement implementation) {
        if (implementation != null) maps.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(HologramImplement implementation) {
        if (implementation != null) holograms.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(RaidActionImplement implementation) {
        if (implementation != null) actions.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(RaidRewardImplement implementation) {
        if (implementation != null) rewards.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(RaidObjectiveImplement implementation) {
        if (implementation != null) objectives.put(requireId(implementation.getId()), implementation);
    }

    synchronized void track(RaidRequirementImplement implementation) {
        if (implementation != null) requirements.put(requireId(implementation.getId()), implementation);
    }

    synchronized void cleanup(UltimateRaids plugin) {
        if (plugin == null) {
            clear();
            return;
        }

        IntegrationAPI integrations = plugin.getIntegrationAPI();
        if (integrations != null) {
            items.forEach((id, implementation) -> {
                if (integrations.getItem(id).orElse(null) == implementation) integrations.unregisterItem(id);
            });
            entities.forEach((id, implementation) -> {
                if (integrations.getEntity(id).orElse(null) == implementation) integrations.unregisterEntity(id);
            });
            groups.forEach((id, implementation) -> {
                if (integrations.getGroup(id).orElse(null) == implementation) integrations.unregisterGroup(id);
            });
            borders.forEach((id, implementation) -> {
                if (integrations.getBorder(id).orElse(null) == implementation) integrations.unregisterBorder(id);
            });
            economies.forEach((id, implementation) -> {
                if (integrations.getEconomy(id).orElse(null) == implementation) integrations.unregisterEconomy(id);
            });
            schematics.forEach((id, implementation) -> {
                if (integrations.getSchematic(id).orElse(null) == implementation) integrations.unregisterSchematic(id);
            });
            visuals.forEach((id, implementation) -> {
                if (integrations.getVisual(id).orElse(null) == implementation) integrations.unregisterVisual(id);
            });
            regions.forEach((id, implementation) -> {
                if (integrations.getRegion(id).orElse(null) == implementation) integrations.unregisterRegion(id);
            });
            scoreboards.forEach((id, implementation) -> {
                if (integrations.getScoreboard(id).orElse(null) == implementation) integrations.unregisterScoreboard(id);
            });
            maps.forEach((id, implementation) -> {
                if (integrations.getMap(id).orElse(null) == implementation) integrations.unregisterMap(id);
            });
            holograms.forEach((id, implementation) -> {
                if (integrations.getHologram(id).orElse(null) == implementation) integrations.unregisterHologram(id);
            });
        }

        RegistryAPI registry = plugin.getRegistryAPI();
        if (registry != null) {
            actions.forEach((id, implementation) -> {
                if (registry.getAction(id).orElse(null) == implementation) registry.unregisterAction(id);
            });
            rewards.forEach((id, implementation) -> {
                if (registry.getReward(id).orElse(null) == implementation) registry.unregisterReward(id);
            });
            objectives.forEach((id, implementation) -> {
                if (registry.getObjective(id).orElse(null) == implementation) registry.unregisterObjective(id);
            });
            requirements.forEach((id, implementation) -> {
                if (registry.getRequirement(id).orElse(null) == implementation) registry.unregisterRequirement(id);
            });
        }

        clear();
    }

    private void clear() {
        items.clear();
        entities.clear();
        groups.clear();
        borders.clear();
        economies.clear();
        schematics.clear();
        visuals.clear();
        regions.clear();
        scoreboards.clear();
        maps.clear();
        holograms.clear();
        actions.clear();
        rewards.clear();
        objectives.clear();
        requirements.clear();
    }

    private static String requireId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Registration id cannot be null or blank");
        }
        return id;
    }
}
