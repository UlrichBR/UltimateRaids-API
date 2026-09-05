package me.ulrich.raids.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** One configured subcommand, following the UltimateClans response model. */
public final class CommandData_sub {

    private final String id;
    private final List<String> aliases;
    private final String permission;
    private final boolean enabled;
    private final int cooldown;
    private final CommandData_show show;
    private final CommandData_actionbar actionbar;
    private final CommandData_title title;
    private final CommandData_sound sound;
    private final Map<String, CommandData_sub> subcommands;

    public CommandData_sub(
            String id,
            List<String> aliases,
            String permission,
            boolean enabled,
            int cooldown,
            CommandData_show show,
            CommandData_actionbar actionbar,
            CommandData_title title,
            CommandData_sound sound,
            Map<String, CommandData_sub> subcommands) {
        this.id = id;
        this.aliases = aliases == null ? new ArrayList<>() : new ArrayList<>(aliases);
        this.permission = permission == null ? "" : permission;
        this.enabled = enabled;
        this.cooldown = Math.max(0, cooldown);
        this.show = show;
        this.actionbar = actionbar;
        this.title = title;
        this.sound = sound;
        this.subcommands = subcommands == null ? new LinkedHashMap<>() : new LinkedHashMap<>(subcommands);
    }

    public String getId() { return id; }
    public List<String> getAliases() { return Collections.unmodifiableList(aliases); }
    public String getPrimaryAlias() { return aliases.isEmpty() ? id : aliases.get(0); }
    public String getPermission() { return permission; }
    public boolean isEnabled() { return enabled; }
    public int getCooldown() { return cooldown; }
    public CommandData_show getShow() { return show; }
    public CommandData_actionbar getActionbar() { return actionbar; }
    public CommandData_title getTitle() { return title; }
    public CommandData_sound getSound() { return sound; }
    public Map<String, CommandData_sub> getSubcommands() { return Collections.unmodifiableMap(subcommands); }
    public boolean hasSubcommands() { return !subcommands.isEmpty(); }

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
}
