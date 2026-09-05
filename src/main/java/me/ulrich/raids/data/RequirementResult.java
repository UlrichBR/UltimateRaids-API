package me.ulrich.raids.data;

/** Result returned by a custom raid requirement processor. */
public record RequirementResult(boolean allowed, String message) {
    public static RequirementResult allow() { return new RequirementResult(true, ""); }
    public static RequirementResult deny(String message) { return new RequirementResult(false, message); }
}
