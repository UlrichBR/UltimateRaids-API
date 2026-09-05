package me.ulrich.raids.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lightweight GUI item metadata model. The string list is intentionally generic
 * so an implementation/extension can consume provider-specific NBT later.
 */
public final class NbtData implements Cloneable {

    private List<String> string;
    private int model;

    public NbtData() {
        this(new ArrayList<>(), 0);
    }

    public NbtData(List<String> string, int model) {
        this.string = string == null ? new ArrayList<>() : new ArrayList<>(string);
        this.model = model;
    }

    public List<String> getString() {
        return Collections.unmodifiableList(string);
    }

    public void setString(List<String> string) {
        this.string = string == null ? new ArrayList<>() : new ArrayList<>(string);
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    @Override
    public NbtData clone() {
        return new NbtData(string, model);
    }
}
