package me.ulrich.raids.api.type;

/** Runtime state of the currently executing stage. */
public enum RaidStageState {
    CREATED,
    RUNNING,
    COMPLETED,
    FAILED,
    STOPPED
}
