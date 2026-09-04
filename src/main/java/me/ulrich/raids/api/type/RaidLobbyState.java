package me.ulrich.raids.api.type;

/** Public matchmaking/lobby lifecycle. */
public enum RaidLobbyState {
    AVAILABLE,
    LOADING_INSTANCE,
    PREPARING,
    WAITING_FOR_PLAYERS,
    WAITING_FOR_READY,
    VOTING,
    COUNTDOWN,
    STARTING,
    RUNNING,
    FINISHING,
    RESETTING
}
