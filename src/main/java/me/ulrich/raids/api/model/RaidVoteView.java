package me.ulrich.raids.api.model;

import java.util.Set;
import java.util.UUID;

/** Read-only state of an active lobby start vote. */
public interface RaidVoteView {
    boolean isActive();
    int getRemainingSeconds();
    int getYesVotes();
    int getNoVotes();
    int getRequiredYesVotes();
    double getRequiredPercent();
    Set<UUID> getYesVoters();
    Set<UUID> getNoVoters();
}
