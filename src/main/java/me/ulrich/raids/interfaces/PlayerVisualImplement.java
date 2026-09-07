package me.ulrich.raids.interfaces;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

/**
 * Provider for client-side player visuals that do not modify the real inventory.
 */
public interface PlayerVisualImplement {

    String getId();

    void showFakeArmor(UUID contextId,
                       Player target,
                       Collection<Player> viewers,
                       Color color,
                       Set<EquipmentSlot> slots);

    void hideFakeArmor(UUID contextId, UUID targetId);

    void clearContext(UUID contextId);

    default Optional<String> getPluginVersion() {
        return Optional.empty();
    }
}
