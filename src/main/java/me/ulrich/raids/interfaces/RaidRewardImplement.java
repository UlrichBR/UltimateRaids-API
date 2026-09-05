package me.ulrich.raids.interfaces;

import me.ulrich.raids.api.context.RewardContext;
import me.ulrich.raids.data.RewardData;

/** Custom reward processor registered through {@code RegistryAPI}. */
public interface RaidRewardImplement {
    String getId();
    boolean grant(RewardContext context, RewardData reward);
}
