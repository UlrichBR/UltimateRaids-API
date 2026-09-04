package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class RaidPlayerEliminatedEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String reason;

    public RaidPlayerEliminatedEvent(RaidInstanceView instance, Player player, String reason) {
        super(instance);
        this.player = player;
        this.reason = reason == null ? "" : reason;
    }

    public Player getPlayer() { return player; }
    public String getReason() { return reason; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
