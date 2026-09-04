package me.ulrich.raids.events;

import java.util.Optional;
import me.ulrich.raids.api.model.RaidGroupView;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/** Fired immediately before a player is admitted to an active raid instance. */
public final class RaidJoinEvent extends RaidEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final RaidGroupView group;
    private boolean cancelled;

    public RaidJoinEvent(RaidInstanceView instance, Player player, RaidGroupView group) {
        super(instance);
        this.player = player;
        this.group = group;
    }

    public Player getPlayer() {
        return player;
    }

    public Optional<RaidGroupView> getGroup() {
        return Optional.ofNullable(group);
    }

    @Override public boolean isCancelled() { return cancelled; }
    @Override public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
