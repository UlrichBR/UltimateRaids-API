package me.ulrich.raids.api.context;

import java.util.Optional;
import java.util.UUID;
import me.ulrich.raids.api.model.RaidContributionView;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/** Safe runtime context passed to custom reward processors. */
public interface RewardContext {
    RaidInstanceView getInstance();
    UUID getPlayerId();
    Optional<Player> getPlayer();
    OfflinePlayer getOfflinePlayer();
    Optional<RaidContributionView> getContribution();
}
