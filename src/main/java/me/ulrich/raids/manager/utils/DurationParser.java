package me.ulrich.raids.manager.utils;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DurationParser {
    private static final Pattern TOKEN = Pattern.compile("(\\d+)\\s*(ms|s|m|h|d|w)", Pattern.CASE_INSENSITIVE);

    private DurationParser() { }

    public static long parseMillis(Object raw) {
        if (raw == null) return 0L;
        if (raw instanceof Number number) return Math.max(0L, number.longValue() * 1000L);
        String value = String.valueOf(raw).trim().toLowerCase(Locale.ROOT);
        if (value.isEmpty() || value.equals("0") || value.equals("none") || value.equals("disabled")) return 0L;
        if (value.matches("\\d+")) return Long.parseLong(value) * 1000L;

        Matcher matcher = TOKEN.matcher(value);
        long total = 0L;
        int matchedUntil = 0;
        boolean found = false;
        while (matcher.find()) {
            String between = value.substring(matchedUntil, matcher.start()).trim();
            if (!between.isEmpty()) return 0L;
            found = true;
            matchedUntil = matcher.end();
            long amount = Long.parseLong(matcher.group(1));
            total = Math.addExact(total, Math.multiplyExact(amount, multiplier(matcher.group(2))));
        }
        if (!found || !value.substring(matchedUntil).trim().isEmpty()) return 0L;
        return Math.max(0L, total);
    }

    private static long multiplier(String unit) {
        return switch (unit.toLowerCase(Locale.ROOT)) {
            case "ms" -> 1L;
            case "s" -> 1_000L;
            case "m" -> 60_000L;
            case "h" -> 3_600_000L;
            case "d" -> 86_400_000L;
            case "w" -> 604_800_000L;
            default -> 0L;
        };
    }

    public static String formatCompact(long millis) {
        long seconds = Math.max(0L, (millis + 999L) / 1000L);
        long days = seconds / 86400L; seconds %= 86400L;
        long hours = seconds / 3600L; seconds %= 3600L;
        long minutes = seconds / 60L; seconds %= 60L;
        StringBuilder out = new StringBuilder();
        if (days > 0) out.append(days).append('d');
        if (hours > 0) { if (!out.isEmpty()) out.append(' '); out.append(hours).append('h'); }
        if (minutes > 0) { if (!out.isEmpty()) out.append(' '); out.append(minutes).append('m'); }
        if (seconds > 0 || out.isEmpty()) { if (!out.isEmpty()) out.append(' '); out.append(seconds).append('s'); }
        return out.toString();
    }
}
