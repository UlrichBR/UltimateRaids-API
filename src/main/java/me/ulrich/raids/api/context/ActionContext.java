package me.ulrich.raids.api.context;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/** Safe runtime context passed to custom action processors. */
public interface ActionContext {
    RaidInstanceView getInstance();
    Optional<RaidStageView> getStage();
    Optional<Player> getTriggerPlayer();
    Optional<Entity> getEntity();
    Map<String, String> values();
    String replace(String input);
    Collection<Player> targets(String selector);
    Optional<Location> location(String selector, Player fallback);
}
