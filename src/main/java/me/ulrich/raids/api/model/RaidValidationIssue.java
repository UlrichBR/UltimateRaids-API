package me.ulrich.raids.api.model;

import java.util.Objects;

/** One validation message produced for a raid definition. */
public final class RaidValidationIssue {

    public enum Severity {
        INFO,
        WARNING,
        ERROR
    }

    private final Severity severity;
    private final String path;
    private final String message;

    public RaidValidationIssue(Severity severity, String path, String message) {
        this.severity = Objects.requireNonNull(severity, "severity");
        this.path = path == null ? "" : path;
        this.message = message == null ? "" : message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
