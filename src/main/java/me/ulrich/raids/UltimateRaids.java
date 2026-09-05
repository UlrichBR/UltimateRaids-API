package me.ulrich.raids;

import me.ulrich.raids.api.AddonAPI;
import me.ulrich.raids.api.CommandAPI;
import me.ulrich.raids.api.ExtensionAPI;
import me.ulrich.raids.api.GuiAPI;
import me.ulrich.raids.api.HooksAPI;
import me.ulrich.raids.api.IntegrationAPI;
import me.ulrich.raids.api.LibAPI;
import me.ulrich.raids.api.RaidAPI;
import me.ulrich.raids.api.RegistryAPI;
import me.ulrich.raids.api.UltimateRaidsAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class UltimateRaids extends JavaPlugin implements UltimateRaidsAPI {

    public static UltimateRaids getInstance() { return null; }

    public static UltimateRaids getRaidCore() { return null; }

    @Override public JavaPlugin getPlugin() { return this; }
    @Override public RaidAPI getRaidAPI() { return null; }
    @Override public IntegrationAPI getIntegrationAPI() { return null; }
    @Override public RegistryAPI getRegistryAPI() { return null; }
    @Override public AddonAPI getAddonAPI() { return null; }
    @Override public ExtensionAPI getExtensionAPI() { return null; }
    @Override public CommandAPI getCommandAPI() { return null; }
    @Override public GuiAPI getGuiAPI() { return null; }
    @Override public HooksAPI getHooksAPI() { return null; }
    @Override public LibAPI getLibAPI() { return null; }
    @Override public String getPluginVersion() { return null; }
    @Override public String getLanguage() { return null; }
    @Override public String getTimeZone() { return null; }
    @Override public String getTag() { return null; }
}
