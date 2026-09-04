package me.ulrich.raids.api.model;

import me.ulrich.raids.api.type.ObjectiveType;
import me.ulrich.raids.api.type.StageCompletionMode;

/** Immutable public summary of one configured stage. */
public interface RaidStageDefinitionView {
    int getIndex();
    String getId();
    String getName();
    StageCompletionMode getCompletionMode();
    ObjectiveType getObjectiveType();
    String getObjectiveTarget();
    int getObjectiveAmount();
    int getWaveCount();
}
