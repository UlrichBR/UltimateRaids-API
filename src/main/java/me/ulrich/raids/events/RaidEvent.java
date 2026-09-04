package me.ulrich.raids.events;

import java.util.Objects;
import me.ulrich.raids.api.model.RaidInstanceView;
import org.bukkit.event.Event;

/** Base class for events tied to a concrete raid instance. */
public abstract class RaidEvent extends Event {

    private final RaidInstanceView instance;

    protected RaidEvent(RaidInstanceView instance) {
        this.instance = Objects.requireNonNull(instance, "instance");
    }

    public RaidInstanceView getInstance() {
        return instance;
    }
}
