package me.ulrich.raids.interfaces;

import java.util.Optional;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/** External world/player border provider contract. */
public interface BorderImplement {
    String getId();
    Object create(String id, Location center, double size);
    void show(Object border, Player player);
    void hide(Object border, Player player);
    void setSize(Object border, double size, long seconds);
    void destroy(Object border);
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
