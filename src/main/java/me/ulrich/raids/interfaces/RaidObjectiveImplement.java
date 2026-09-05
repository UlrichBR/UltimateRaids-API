package me.ulrich.raids.interfaces;

import java.util.UUID;
import me.ulrich.raids.api.context.ObjectiveContext;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

/** Custom objective processor registered through {@code RegistryAPI}. */
public interface RaidObjectiveImplement {
    String getId();
    default void start(ObjectiveContext context) { }
    default void tick(ObjectiveContext context) { }
    default void onEntityDeath(ObjectiveContext context, Entity entity, UUID killerId) { }
    default void onPlayerMove(ObjectiveContext context, UUID playerId, Location from, Location to) { }
    default void onPlayerInteract(ObjectiveContext context, UUID playerId, Action action, Block block, Entity entity) { }
    default void onPlayerInteractEntity(ObjectiveContext context, UUID playerId, Entity entity) { }
    default void onBlockBreak(ObjectiveContext context, UUID playerId, Block block) { }
    default void onItemPickup(ObjectiveContext context, UUID playerId, ItemStack item, int amount) { }
    default boolean allowsBlockBreak(ObjectiveContext context, UUID playerId, Block block) { return false; }
    default boolean allowsItemPickup(ObjectiveContext context, UUID playerId, ItemStack item) { return false; }
    default String getFailureReason(ObjectiveContext context) { return null; }
    boolean isComplete(ObjectiveContext context);
    default void stop(ObjectiveContext context) { }
}
