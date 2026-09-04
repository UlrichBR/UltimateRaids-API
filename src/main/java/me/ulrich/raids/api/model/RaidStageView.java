package me.ulrich.raids.api.model;

import me.ulrich.raids.api.type.RaidStageState;

/** Read-only runtime snapshot of one active stage. */
public interface RaidStageView {
    RaidStageDefinitionView getDefinition();
    RaidStageState getState();
    int getObjectiveProgress();
    int getWaveIndex();
    int getWaveTotal();
    long getElapsedSeconds();

    default int getIndex() {
        return getDefinition().getIndex();
    }

    default String getId() {
        return getDefinition().getId();
    }

    default int getObjectiveAmount() {
        return getDefinition().getObjectiveAmount();
    }
}
