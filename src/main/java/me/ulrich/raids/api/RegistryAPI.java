package me.ulrich.raids.api;

import java.util.Optional;
import java.util.Set;
import me.ulrich.raids.interfaces.RaidActionImplement;
import me.ulrich.raids.interfaces.RaidObjectiveImplement;
import me.ulrich.raids.interfaces.RaidRequirementImplement;
import me.ulrich.raids.interfaces.RaidRewardImplement;

/** Registry for raid processors that may be supplied by addons/extensions. */
public interface RegistryAPI {
    void registerAction(RaidActionImplement implementation);
    void registerReward(RaidRewardImplement implementation);
    void registerObjective(RaidObjectiveImplement implementation);
    void registerRequirement(RaidRequirementImplement implementation);

    void unregisterAction(String id);
    void unregisterReward(String id);
    void unregisterObjective(String id);
    void unregisterRequirement(String id);

    Optional<RaidActionImplement> getAction(String id);
    Optional<RaidRewardImplement> getReward(String id);
    Optional<RaidObjectiveImplement> getObjective(String id);
    Optional<RaidRequirementImplement> getRequirement(String id);

    Set<String> getActionIds();
    Set<String> getRewardIds();
    Set<String> getObjectiveIds();
    Set<String> getRequirementIds();
}
