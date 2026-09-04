package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import org.bukkit.event.HandlerList;

public final class RaidObjectiveFailEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final RaidStageView stage;
    private final String reason;

    public RaidObjectiveFailEvent(RaidInstanceView instance, RaidStageView stage, String reason) {
        super(instance);
        this.stage = stage;
        this.reason = reason == null ? "" : reason;
    }

    public RaidStageView getStage() { return stage; }
    public String getReason() { return reason; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
