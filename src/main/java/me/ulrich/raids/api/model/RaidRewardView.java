package me.ulrich.raids.api.model;

import java.util.Map;

/** Read-only reward definition exposed by {@code RaidRewardEvent}. */
public interface RaidRewardView {
    String getType();
    double getChance();
    Map<String, Object> getOptions();
}
