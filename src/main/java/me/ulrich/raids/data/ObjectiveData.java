package me.ulrich.raids.data;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Immutable objective configuration supplied to external objective processors. */
public record ObjectiveData(String type, String target, int amount, Map<String, Object> options) {
    public ObjectiveData {
        options = Collections.unmodifiableMap(new LinkedHashMap<>(options == null ? Map.of() : options));
    }
    public String string(String key, String fallback) { Object v = options.get(key); return v == null ? fallback : String.valueOf(v); }
    public int integer(String key, int fallback) { Object v = options.get(key); if (v instanceof Number n) return n.intValue(); try { return v == null ? fallback : Integer.parseInt(String.valueOf(v)); } catch (Exception ignored) { return fallback; } }
    public double decimal(String key, double fallback) { Object v = options.get(key); if (v instanceof Number n) return n.doubleValue(); try { return v == null ? fallback : Double.parseDouble(String.valueOf(v)); } catch (Exception ignored) { return fallback; } }
    public boolean bool(String key, boolean fallback) { Object v = options.get(key); return v instanceof Boolean b ? b : v == null ? fallback : Boolean.parseBoolean(String.valueOf(v)); }
}
