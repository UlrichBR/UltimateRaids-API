package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class RaidPlayerDisconnectEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final int graceSeconds;

    public RaidPlayerDisconnectEvent(RaidInstanceView instance, Player player, int graceSeconds) {
        super(instance);
        this.player = player;
        this.graceSeconds = Math.max(0, graceSeconds);
    }

    public Player getPlayer() { return player; }
    public int getGraceSeconds() { return graceSeconds; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
