package me.ulrich.raids.api.result;

import java.util.Optional;
import java.util.UUID;

/** Result of a direct API start request. */
public final class RaidStartResult {

    public enum Status {
        STARTED,
        LOADING,
        DENIED
    }

    private final Status status;
    private final String message;
    private final UUID instanceId;

    public RaidStartResult(Status status, String message, UUID instanceId) {
        this.status = status == null ? Status.DENIED : status;
        this.message = message == null ? "" : message;
        this.instanceId = instanceId;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Optional<UUID> getInstanceId() {
        return Optional.ofNullable(instanceId);
    }

    public boolean isSuccess() {
        return status != Status.DENIED;
    }
}
