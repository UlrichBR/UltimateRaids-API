package me.ulrich.raids.api.result;

/** Result of checking or attempting access to an active raid instance. */
public final class RaidAccessResult {

    public enum Reason {
        ALLOWED,
        GENERIC,
        RAID_NOT_FOUND,
        RAID_DISABLED,
        INVALID_STATE,
        INSTANCE_LOADING,
        INSTANCE_FULL,
        LATE_JOIN_DISABLED,
        NOT_ALLOWED_DAY,
        NOT_ALLOWED_TIME,
        GROUP_PROVIDER_UNAVAILABLE,
        GROUP_REQUIRED,
        SOLO_OCCUPIED,
        GROUP_MISMATCH,
        GROUP_LIMIT,
        PLAYER_COOLDOWN,
        GROUP_COOLDOWN,
        GLOBAL_COOLDOWN,
        REQUIREMENT_FAILED,
        KIT_UNAVAILABLE,
        JOIN_CANCELLED
    }

    private final boolean allowed;
    private final Reason reason;
    private final String message;
    private final long remainingMillis;

    public RaidAccessResult(boolean allowed, Reason reason, String message, long remainingMillis) {
        this.allowed = allowed;
        this.reason = reason == null ? (allowed ? Reason.ALLOWED : Reason.GENERIC) : reason;
        this.message = message == null ? "" : message;
        this.remainingMillis = Math.max(0L, remainingMillis);
    }

    public static RaidAccessResult allowed() {
        return new RaidAccessResult(true, Reason.ALLOWED, "", 0L);
    }

    public static RaidAccessResult denied(Reason reason, String message) {
        return new RaidAccessResult(false, reason, message, 0L);
    }

    public static RaidAccessResult cooldown(Reason reason, String message, long remainingMillis) {
        return new RaidAccessResult(false, reason, message, remainingMillis);
    }

    public boolean isAllowed() {
        return allowed;
    }

    public Reason getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }

    public long getRemainingMillis() {
        return remainingMillis;
    }
}
