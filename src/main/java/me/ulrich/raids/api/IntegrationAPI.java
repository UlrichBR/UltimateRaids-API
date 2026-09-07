package me.ulrich.raids.api;

import java.util.Optional;
import java.util.Set;
import me.ulrich.raids.interfaces.BorderImplement;
import me.ulrich.raids.interfaces.EconomyImplement;
import me.ulrich.raids.interfaces.EntityImplement;
import me.ulrich.raids.interfaces.GroupImplement;
import me.ulrich.raids.interfaces.ItemParseImplement;
import me.ulrich.raids.interfaces.PlayerVisualImplement;
import me.ulrich.raids.interfaces.SchematicImplement;

/** Registry for external compatibility/provider implementations. */
public interface IntegrationAPI {
    Optional<ItemParseImplement> registerItem(ItemParseImplement implementation);
    Optional<EntityImplement> registerEntity(EntityImplement implementation);
    Optional<GroupImplement> registerGroup(GroupImplement implementation);
    Optional<BorderImplement> registerBorder(BorderImplement implementation);
    Optional<EconomyImplement> registerEconomy(EconomyImplement implementation);
    Optional<SchematicImplement> registerSchematic(SchematicImplement implementation);
    Optional<PlayerVisualImplement> registerVisual(PlayerVisualImplement implementation);

    void unregisterItem(String id);
    void unregisterEntity(String id);
    void unregisterGroup(String id);
    void unregisterBorder(String id);
    void unregisterEconomy(String id);
    void unregisterSchematic(String id);
    void unregisterVisual(String id);
    void unregisterAll(String id);

    Optional<ItemParseImplement> getItem(String id);
    Optional<EntityImplement> getEntity(String id);
    Optional<GroupImplement> getGroup(String id);
    Optional<BorderImplement> getBorder(String id);
    Optional<EconomyImplement> getEconomy(String id);
    Optional<SchematicImplement> getSchematic(String id);
    Optional<PlayerVisualImplement> getVisual(String id);

    Set<String> getItemIds();
    Set<String> getEntityIds();
    Set<String> getGroupIds();
    Set<String> getBorderIds();
    Set<String> getEconomyIds();
    Set<String> getSchematicIds();
    Set<String> getVisualIds();
}
