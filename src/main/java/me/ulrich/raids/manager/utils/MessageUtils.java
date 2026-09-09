package me.ulrich.raids.manager.utils;

import java.util.List;

import me.ulrich.raids.data.CommandData;
import me.ulrich.raids.data.CommandData_sub;
import me.ulrich.raids.data.RaidEnums.MsgUsage;
import org.bukkit.command.CommandSender;

/**
 * Public compile-time facade for the UltimateRaids message utilities.
 *
 * <p>The runtime implementation is supplied by the UltimateRaids Core.
 * Addons and extensions should depend on UltimateRaids-API with
 * {@code provided} scope and must not shade this API class.</p>
 */
public final class MessageUtils {

    private MessageUtils() {
    }

    public static void sendCommandJson(CommandSender sender, CommandData command, MsgUsage usage, List<String> data) {
        throw runtimeOnly();
    }

    public static void sendSubCommandJson(CommandSender sender, CommandData command, String subcommand,
                                          MsgUsage usage, List<String> data) {
        throw runtimeOnly();
    }

    public static void sendSubCommandJson(CommandSender sender, CommandData_sub sub, MsgUsage usage,
                                          List<String> data) {
        throw runtimeOnly();
    }

    public static void sendChildCommandJson(CommandSender sender, CommandData command, String parent, String child,
                                            MsgUsage usage, List<String> data) {
        throw runtimeOnly();
    }

    public static void sendText(CommandSender sender, String text) {
        throw runtimeOnly();
    }

    public static void sendText(CommandSender sender, String text, List<String> data) {
        throw runtimeOnly();
    }

    public static String parse(String text, List<String> data) {
        throw runtimeOnly();
    }

    private static UnsupportedOperationException runtimeOnly() {
        return new UnsupportedOperationException("MessageUtils runtime implementation is supplied by UltimateRaids Core");
    }
}
