package me.ulrich.raids.api.type;

/** High-level lifecycle of one raid execution. */
public enum RaidState {
    CREATED,
    LOADING,
    WAITING,
    STARTING,
    RUNNING,
    COMPLETING,
    COMPLETED,
    FAILED,
    CANCELLING,
    CANCELLED,
    RESETTING
}
