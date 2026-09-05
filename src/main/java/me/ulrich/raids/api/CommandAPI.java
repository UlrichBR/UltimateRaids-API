package me.ulrich.raids.api;

import java.util.Collection;
import me.ulrich.raids.interfaces.RaidSubCommand;

/** Public command integration surface for addons. */
public interface CommandAPI {
    void registerSubCommand(String root, RaidSubCommand command);
    void unregisterSubCommand(String root, String name);
    Collection<RaidSubCommand> getSubCommands(String root);
}
