package me.ulrich.raids.events;

import java.util.Objects;
import me.ulrich.raids.api.model.RaidLobbyView;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** Fired after a public matchmaking lobby has been created. */
public final class RaidLobbyCreateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final RaidLobbyView lobby;

    public RaidLobbyCreateEvent(RaidLobbyView lobby) {
        this.lobby = Objects.requireNonNull(lobby, "lobby");
    }

    public RaidLobbyView getLobby() {
        return lobby;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
