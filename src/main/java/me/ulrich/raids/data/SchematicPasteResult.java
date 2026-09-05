package me.ulrich.raids.data;

/** Result returned by a schematic provider. */
public record SchematicPasteResult(boolean success, String message) {
    public static SchematicPasteResult ok() { return new SchematicPasteResult(true, ""); }
    public static SchematicPasteResult failure(String message) { return new SchematicPasteResult(false, message); }
}
