package me.ulrich.raids.events;

import java.util.UUID;
import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidRewardView;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/** Fired before a configured raid reward is granted. */
public final class RaidRewardEvent extends RaidEvent implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerId;
    private final String section;
    private final RaidRewardView reward;
    private boolean cancelled;

    public RaidRewardEvent(RaidInstanceView instance, UUID playerId, String section, RaidRewardView reward) {
        super(instance);
        this.playerId = playerId;
        this.section = section == null ? "" : section;
        this.reward = reward;
    }

    public UUID getPlayerId() { return playerId; }
    public String getSection() { return section; }
    public RaidRewardView getReward() { return reward; }

    @Override public boolean isCancelled() { return cancelled; }
    @Override public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
