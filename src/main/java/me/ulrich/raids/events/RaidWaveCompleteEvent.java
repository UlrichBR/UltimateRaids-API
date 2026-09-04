package me.ulrich.raids.events;

import me.ulrich.raids.api.model.RaidInstanceView;
import me.ulrich.raids.api.model.RaidStageView;
import org.bukkit.event.HandlerList;

public final class RaidWaveCompleteEvent extends RaidEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private final RaidStageView stage;
    private final String waveId;
    private final int waveIndex;

    public RaidWaveCompleteEvent(RaidInstanceView instance, RaidStageView stage, String waveId, int waveIndex) {
        super(instance);
        this.stage = stage;
        this.waveId = waveId == null ? "" : waveId;
        this.waveIndex = Math.max(0, waveIndex);
    }

    public RaidStageView getStage() { return stage; }
    public String getWaveId() { return waveId; }
    public int getWaveIndex() { return waveIndex; }

    @Override public HandlerList getHandlers() { return HANDLERS; }
    public static HandlerList getHandlerList() { return HANDLERS; }
}
