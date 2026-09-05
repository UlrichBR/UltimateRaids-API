package me.ulrich.raids.interfaces;

import java.util.List;
import org.bukkit.command.CommandSender;

/** Public subcommand contract that addons may register under a supported root command. */
public interface RaidSubCommand {
    String getName();
    default List<String> getAliases() { return List.of(); }
    default String getPermission() { return ""; }
    boolean execute(CommandSender sender, String label, String[] args);
    default List<String> tabComplete(CommandSender sender, String alias, String[] args) { return List.of(); }
}
