package me.ulrich.raids.interfaces;

import java.util.Optional;
import org.bukkit.inventory.ItemStack;

/** External custom-item provider contract. */
public interface ItemParseImplement {
    String getId();
    ItemStack getItem(String itemName);
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
