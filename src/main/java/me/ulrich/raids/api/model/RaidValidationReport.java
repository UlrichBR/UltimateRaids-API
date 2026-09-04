package me.ulrich.raids.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Immutable validation result returned by the public API. */
public final class RaidValidationReport {

    private final String raidId;
    private final List<RaidValidationIssue> issues;

    public RaidValidationReport(String raidId, List<RaidValidationIssue> issues) {
        this.raidId = raidId == null ? "" : raidId;
        this.issues = Collections.unmodifiableList(new ArrayList<>(issues == null ? List.of() : issues));
    }

    public String getRaidId() {
        return raidId;
    }

    public List<RaidValidationIssue> getIssues() {
        return issues;
    }

    public long getErrors() {
        return issues.stream()
                .filter(issue -> issue.getSeverity() == RaidValidationIssue.Severity.ERROR)
                .count();
    }

    public long getWarnings() {
        return issues.stream()
                .filter(issue -> issue.getSeverity() == RaidValidationIssue.Severity.WARNING)
                .count();
    }

    public boolean isValid() {
        return getErrors() == 0L;
    }
}
