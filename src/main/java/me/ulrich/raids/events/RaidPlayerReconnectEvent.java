package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class RaidPlayerReconnectEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;

    public RaidPlayerReconnectEvent(RaidInstanceView instance, Player player) {
        super(instance);
        this.player = player;
    }

    public Player getPlayer() { return player; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
