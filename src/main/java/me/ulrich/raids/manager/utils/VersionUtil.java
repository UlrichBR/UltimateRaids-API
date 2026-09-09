package me.ulrich.raids.manager.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class VersionUtil {

    private VersionUtil() {
    }

    public static boolean isAtLeast(String current, String minimum) {
        if (minimum == null || minimum.isBlank() || minimum.equals("0")) return true;
        if (current == null || current.isBlank()) return false;
        return compare(current, minimum) >= 0;
    }

    static int compare(String left, String right) {
        ParsedVersion current = parse(left);
        ParsedVersion minimum = parse(right);

        int base = compareNumbers(current.base(), minimum.base());
        if (base != 0) return base;

        int stage = Integer.compare(current.stage().rank, minimum.stage().rank);
        if (stage != 0) return stage;

        return compareNumbers(current.qualifier(), minimum.qualifier());
    }

    private static ParsedVersion parse(String version) {
        String normalized = version == null ? "" : version.trim().toUpperCase(Locale.ROOT);
        int separator = normalized.indexOf('-');

        String baseText = separator < 0 ? normalized : normalized.substring(0, separator);
        String suffix = separator < 0 ? "" : normalized.substring(separator + 1);

        List<Integer> base = numericParts(baseText);
        Stage stage = stageOf(suffix);
        List<Integer> qualifier = qualifierParts(suffix);

        return new ParsedVersion(base, stage, qualifier);
    }

    private static Stage stageOf(String suffix) {
        if (suffix == null || suffix.isBlank()) return Stage.RELEASE;

        String value = suffix.toUpperCase(Locale.ROOT);

        // Check pre-release markers before RELEASE because versions such as
        // BETA-3.0-RELEASE still belong to the BETA stage.
        if (value.contains("ALPHA")) return Stage.ALPHA;
        if (value.contains("BETA")) return Stage.BETA;
        if (value.contains("RC")) return Stage.RC;
        if (value.contains("SNAPSHOT")) return Stage.SNAPSHOT;
        if (value.contains("RELEASE") || value.contains("FINAL") || value.contains("STABLE")) {
            return Stage.RELEASE;
        }

        return Stage.OTHER;
    }

    private static List<Integer> qualifierParts(String suffix) {
        if (suffix == null || suffix.isBlank()) return List.of();

        String value = suffix
                .replaceAll("(?i)ALPHA", "")
                .replaceAll("(?i)BETA", "")
                .replaceAll("(?i)SNAPSHOT", "")
                .replaceAll("(?i)RELEASE", "")
                .replaceAll("(?i)FINAL", "")
                .replaceAll("(?i)STABLE", "")
                .replaceAll("(?i)RC", "");

        return numericParts(value);
    }

    private static int compareNumbers(List<Integer> left, List<Integer> right) {
        int max = Math.max(left.size(), right.size());

        for (int i = 0; i < max; i++) {
            int a = i < left.size() ? left.get(i) : 0;
            int b = i < right.size() ? right.get(i) : 0;

            if (a != b) return Integer.compare(a, b);
        }

        return 0;
    }

    private static List<Integer> numericParts(String version) {
        List<Integer> parts = new ArrayList<>();
        if (version == null || version.isBlank()) return parts;

        String[] tokens = version.split("[^0-9]+");
        for (String token : tokens) {
            if (token.isEmpty()) continue;

            try {
                parts.add(Integer.parseInt(token));
            } catch (NumberFormatException ignored) {
                parts.add(0);
            }
        }

        return parts;
    }

    private enum Stage {
        ALPHA(10),
        BETA(20),
        OTHER(25),
        RC(30),
        SNAPSHOT(40),
        RELEASE(50);

        private final int rank;

        Stage(int rank) {
            this.rank = rank;
        }
    }

    private record ParsedVersion(List<Integer> base, Stage stage, List<Integer> qualifier) {
    }
}
