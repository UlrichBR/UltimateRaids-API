package me.ulrich.raids.interfaces;

import java.util.Optional;
import me.ulrich.raids.data.SchematicPasteRequest;
import me.ulrich.raids.data.SchematicPasteResult;

/** External schematic provider contract, for example WorldEdit or FAWE. */
public interface SchematicImplement {
    String getId();
    boolean isAvailable();
    SchematicPasteResult paste(SchematicPasteRequest request);
    default boolean supportsFile(String fileName) { return fileName != null && fileName.toLowerCase().endsWith(".schem"); }
    default Optional<String> getPluginVersion() { return Optional.empty(); }
}
