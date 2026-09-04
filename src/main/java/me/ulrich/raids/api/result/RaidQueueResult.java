package me.ulrich.raids.api.result;

import java.util.Optional;
import java.util.UUID;

/** Result returned by lobby/queue entry operations. */
public final class RaidQueueResult {

    public enum Status {
        QUEUED,
        LOADING,
        STARTED,
        ALREADY_QUEUED,
        DENIED
    }

    private final Status status;
    private final String message;
    private final UUID lobbyId;
    private final UUID instanceId;

    public RaidQueueResult(Status status, String message, UUID lobbyId, UUID instanceId) {
        this.status = status == null ? Status.DENIED : status;
        this.message = message == null ? "" : message;
        this.lobbyId = lobbyId;
        this.instanceId = instanceId;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Optional<UUID> getLobbyId() {
        return Optional.ofNullable(lobbyId);
    }

    public Optional<UUID> getInstanceId() {
        return Optional.ofNullable(instanceId);
    }

    public boolean isSuccess() {
        return status != Status.DENIED;
    }
}
