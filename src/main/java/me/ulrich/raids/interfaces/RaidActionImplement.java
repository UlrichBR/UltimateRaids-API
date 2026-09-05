package me.ulrich.raids.interfaces;

import me.ulrich.raids.api.context.ActionContext;
import me.ulrich.raids.data.ActionData;

/** Custom action processor registered through {@code RegistryAPI}. */
public interface RaidActionImplement {
    String getId();
    void execute(ActionContext context, ActionData action);
}
