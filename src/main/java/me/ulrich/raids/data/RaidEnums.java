package me.ulrich.raids.data;

/**
 * Legacy enum container retained only for migration compatibility.
 *
 * @deprecated use the dedicated enums in {@code me.ulrich.raids.api.type}.
 */
@Deprecated(forRemoval = true)
public final class RaidEnums {
    private RaidEnums() {}
    public enum RaidState { CREATED, WAITING, STARTING, RUNNING, COMPLETING, COMPLETED, FAILED, CANCELLING, CANCELLED }
    public enum ParticipationMode { SOLO, PUBLIC, GROUP, COMPETITIVE }
    public enum EntryMode { NORMAL, MINIGAME }
    public enum LoadoutMode { PLAYER, KIT }
    public enum ProgressionMode { STANDARD, DISCOVERY }
    public enum StageEntryRequirement { ANY_PLAYER, ALL_PLAYERS, PERCENTAGE }
    public enum LobbyState { WAITING, PREPARING, VOTING, COUNTDOWN, STARTING, RESETTING }
    public enum EnvironmentMode { OPEN_WORLD, DYNAMIC, REGION, ARENA, INSTANCE }
    public enum InstanceSource { WORLD, SCHEMATIC, VOID }
    public enum InstanceLoadPhase { VALIDATING, COPYING_WORLD, CREATING_WORLD, PASTING_SCHEMATIC, PRELOADING_CHUNKS, READY }
    public enum CommandPolicy { WHITELIST, BLACKLIST }
    public enum PlayerDeathMode { RESPAWN, LIVES, SPECTATOR, REMOVE }
    public enum ParticipantState { ACTIVE, DEAD, SPECTATOR, DISCONNECTED, ELIMINATED, LEFT }
    public enum RespawnLocationMode { ORIGIN, DEATH, ENTRY }
    public enum MsgUsage { HELP, SUCCESS, ERROR, USAGE }
    public enum ObjectiveType { NONE, KILL_ENTITIES, KILL_BOSS, SURVIVE, REACH_LOCATION, DEFEND, DESTROY, COLLECT, INTERACT, CAPTURE, ESCORT, CUSTOM }
}
