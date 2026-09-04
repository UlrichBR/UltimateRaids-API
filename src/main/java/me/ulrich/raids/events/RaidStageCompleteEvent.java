package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import org.bukkit.event.HandlerList;

public final class RaidStageCompleteEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final RaidStageView stage;

    public RaidStageCompleteEvent(RaidInstanceView instance, RaidStageView stage) {
        super(instance);
        this.stage = stage;
    }

    public RaidStageView getStage() { return stage; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
