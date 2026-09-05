package me.ulrich.raids.data;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/** Command configuration model based on the UltimateClans command response structure. */
public final class CommandData {

    private final String id;
    private final String alias;
    private final String permission;
    private final CommandData_show show;
    private final CommandData_actionbar actionbar;
    private final CommandData_title title;
    private final CommandData_sound sound;
    private final Map<String, CommandData_sub> subcommands;

    public CommandData(
            String id,
            String alias,
            String permission,
            CommandData_show show,
            CommandData_actionbar actionbar,
            CommandData_title title,
            CommandData_sound sound,
            Map<String, CommandData_sub> subcommands) {
        this.id = id;
        this.alias = alias;
        this.permission = permission == null ? "" : permission;
        this.show = show;
        this.actionbar = actionbar;
        this.title = title;
        this.sound = sound;
        this.subcommands = new LinkedHashMap<>(subcommands);
    }

    public String getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getPermission() {
        return permission;
    }

    public CommandData_show getShow() {
        return show;
    }

    public CommandData_actionbar getActionbar() {
        return actionbar;
    }

    public CommandData_title getTitle() {
        return title;
    }

    public CommandData_sound getSound() {
        return sound;
    }

    public Map<String, CommandData_sub> getSubcommands() {
        return Collections.unmodifiableMap(subcommands);
    }

    public CommandData_sub getSubcommand(String id) {
        return id == null ? null : subcommands.get(id.toLowerCase(Locale.ROOT));
    }

    public String resolveSubcommand(String value) {
        if (value == null) return null;
        for (Map.Entry<String, CommandData_sub> entry : subcommands.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(value)) return entry.getKey();
            if (entry.getValue().getAliases().stream().anyMatch(alias -> alias.equalsIgnoreCase(value))) return entry.getKey();
        }
        return null;
    }

    // Compatibility helpers for command implementations.
    public String getShow(String usage) {
        if (show == null) return "";
        return switch (usage.toLowerCase(Locale.ROOT)) {
            case "help" -> show.getOn_help();
            case "success" -> show.getOn_success();
            case "error" -> show.getOn_error();
            case "usage" -> show.getOn_usage();
            default -> "";
        };
    }

    public String getUsage(String subcommand) {
        CommandData_sub data = getSubcommand(subcommand);
        return data == null || data.getShow() == null ? "" : data.getShow().getOn_usage();
    }
}
