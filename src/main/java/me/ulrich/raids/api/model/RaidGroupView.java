package me.ulrich.raids.api.model;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/** Read-only group snapshot used by GROUP/COMPETITIVE raids. */
public interface RaidGroupView {
    UUID getId();
    String getName();
    String getTag();
    Optional<UUID> getLeader();
    Collection<UUID> getMembers();
}
