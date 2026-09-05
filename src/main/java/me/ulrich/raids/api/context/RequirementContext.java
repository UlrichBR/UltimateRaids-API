package me.ulrich.raids.api.context;

import java.util.Optional;
import me.ulrich.raids.api.model.RaidDefinitionView;
import me.ulrich.raids.api.model.RaidGroupView;
import org.bukkit.entity.Player;

/** Safe context passed to custom access requirement processors. */
public interface RequirementContext {
    Player getPlayer();
    RaidDefinitionView getRaid();
    Optional<RaidGroupView> getGroup();
}
