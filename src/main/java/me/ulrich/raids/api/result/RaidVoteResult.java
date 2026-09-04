package me.ulrich.raids.api.result;

import java.util.Optional;
import me.ulrich.raids.api.model.RaidVoteView;

/** Result returned by READY/vote actions. */
public final class RaidVoteResult {

    private final boolean success;
    private final String message;
    private final RaidVoteView vote;

    public RaidVoteResult(boolean success, String message, RaidVoteView vote) {
        this.success = success;
        this.message = message == null ? "" : message;
        this.vote = vote;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Optional<RaidVoteView> getVote() {
        return Optional.ofNullable(vote);
    }
}
