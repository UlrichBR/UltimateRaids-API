package me.ulrich.raids.data;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Public request passed to custom entity providers. */
public final class EntitySpawnRequest {
    private final String provider;
    private final String type;
    private final String name;
    private final double health;
    private final Map<String, Object> options;

    public EntitySpawnRequest(String provider, String type, String name, double health, Map<String, Object> options) {
        this.provider = provider;
        this.type = type;
        this.name = name;
        this.health = health;
        this.options = Collections.unmodifiableMap(new LinkedHashMap<>(options == null ? Map.of() : options));
    }

    public String getProvider() { return provider; }
    public String getType() { return type; }
    public String getName() { return name; }
    public double getHealth() { return health; }
    public Map<String, Object> getOptions() { return options; }
}
