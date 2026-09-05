package me.ulrich.raids.interfaces;

import me.ulrich.raids.api.context.RequirementContext;
import me.ulrich.raids.data.RequirementData;
import me.ulrich.raids.data.RequirementResult;

/** Custom access requirement processor registered through {@code RegistryAPI}. */
public interface RaidRequirementImplement {
    String getId();
    RequirementResult check(RequirementContext context, RequirementData requirement);
}
