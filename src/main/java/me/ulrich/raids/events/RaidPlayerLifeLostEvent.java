package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class RaidPlayerLifeLostEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final int livesRemaining;

    public RaidPlayerLifeLostEvent(RaidInstanceView instance, Player player, int livesRemaining) {
        super(instance);
        this.player = player;
        this.livesRemaining = Math.max(0, livesRemaining);
    }

    public Player getPlayer() { return player; }
    public int getLivesRemaining() { return livesRemaining; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
