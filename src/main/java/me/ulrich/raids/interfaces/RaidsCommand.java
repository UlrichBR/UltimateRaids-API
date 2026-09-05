package me.ulrich.raids.interfaces;

import java.util.EnumMap;
import me.ulrich.raids.UltimateRaids;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public interface RaidsCommand extends TabCompleter {
    enum Flag { ROOT, PERMISSION }
    boolean execute(UltimateRaids plugin, CommandSender sender, Command command, String label, String[] args, EnumMap<Flag, String> info);
}
