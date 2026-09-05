package me.ulrich.raids.interfaces;

import java.util.Optional;
import java.util.UUID;

/** External economy provider contract. */
public interface EconomyImplement {
    String getId();
    double getBalance(UUID playerId);
    boolean withdraw(UUID playerId, double amount);
    boolean deposit(UUID playerId, double amount);
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
