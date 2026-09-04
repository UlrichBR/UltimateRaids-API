package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import org.bukkit.event.HandlerList;

public final class RaidObjectiveProgressEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final RaidStageView stage;
    private final int progress;
    private final int amount;

    public RaidObjectiveProgressEvent(RaidInstanceView instance, RaidStageView stage, int progress, int amount) {
        super(instance);
        this.stage = stage;
        this.progress = Math.max(0, progress);
        this.amount = Math.max(0, amount);
    }

    public RaidStageView getStage() { return stage; }
    public int getProgress() { return progress; }
    public int getAmount() { return amount; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
