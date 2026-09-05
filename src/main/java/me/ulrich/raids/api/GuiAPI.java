package me.ulrich.raids.api;

import org.bukkit.entity.Player;

/** Stable GUI entry points without exposing the GUI implementation library. */
public interface GuiAPI {
    void openRaids(Player player);
    void openRaid(Player player, String raidId);
    void openLobbyActions(Player player);
    void openStatus(Player player);
    void openAdmin(Player player);
    void close(Player player);
    void closeAll();
}
