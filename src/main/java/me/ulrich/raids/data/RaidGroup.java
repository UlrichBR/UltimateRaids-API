package me.ulrich.raids.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

/** Immutable group representation supplied by external group providers. */
public final class RaidGroup {
    private final UUID id;
    private final String name;
    private final String tag;
    private final UUID leader;
    private final Collection<UUID> members;

    public RaidGroup(UUID id, String name, String tag, UUID leader, Collection<UUID> members) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.leader = leader;
        this.members = Collections.unmodifiableList(new ArrayList<>(members == null ? ListHolder.EMPTY : members));
    }

    private static final class ListHolder { private static final Collection<UUID> EMPTY = java.util.List.of(); }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getTag() { return tag; }
    public Optional<UUID> getLeader() { return Optional.ofNullable(leader); }
    public Collection<UUID> getMembers() { return members; }
}
