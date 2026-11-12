package me.ulrich.raids.api.util;

import org.bukkit.command.CommandSender;

/** Permission namespace compatibility bridge for the RaidWeaver rebrand. */
public final class PermissionCompat {

    private static final String CURRENT = "raidweaver.";
    private static final String LEGACY = "ultimateraids.";

    private PermissionCompat() {
    }

    public static boolean has(CommandSender sender, String permission) {
        if (sender == null) return false;
        if (permission == null || permission.isBlank()) return true;
        if (sender.hasPermission(permission)) return true;
        String alternate = alternate(permission);
        return alternate != null && sender.hasPermission(alternate);
    }

    public static String alternate(String permission) {
        if (permission == null) return null;
        if (permission.startsWith(CURRENT)) return LEGACY + permission.substring(CURRENT.length());
        if (permission.startsWith(LEGACY)) return CURRENT + permission.substring(LEGACY.length());
        return null;
    }
}
