package me.ulrich.raids.data;

import java.io.File;
import org.bukkit.Location;
import org.bukkit.World;

/** Request passed to an external schematic implementation. */
public record SchematicPasteRequest(World world, File schematic, Location origin, boolean ignoreAir) {
}
