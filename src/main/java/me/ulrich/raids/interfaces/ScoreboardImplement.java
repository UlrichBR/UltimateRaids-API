package me.ulrich.raids.interfaces;

import java.util.Optional;
import org.bukkit.entity.Player;

/**
 * Bridge for server scoreboard plugins.
 *
 * <p>Providers do not create the UltimateRaids scoreboard. They only suspend
 * and restore the server/plugin scoreboard while the native raid scoreboard is
 * active.</p>
 */
public interface ScoreboardImplement {
    String getId();
    boolean hidePluginScoreboard(Player player);
    boolean showPluginScoreboard(Player player);
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
