package me.ulrich.raids.interfaces;

import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.PaginatedGui;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.raids.data.GuiData;
import org.bukkit.entity.Player;

public interface GuiAPI {

    ConcurrentHashMap<String, GuiData> getInsertGui();

    List<Player> getOpenedGuiPlayers();

    void closeAllOpened();

    void insertItens(Gui gui, String group, String page, Player player);

    void insertItens(PaginatedGui gui, String group, String page, Player player);

    void close(Player player);

    boolean useTitleAlerts();

    void openRaids(Player player);

    void openAdmin(Player player);
}
