package me.ulrich.raids.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Slot filler definition kept compatible with the GUI model used by UltimateClans.
 */
public final class GuiItemsData_fill implements Cloneable {

    private List<Integer> slots;
    private boolean all;
    private boolean top;
    private boolean border;
    private boolean bottom;

    public GuiItemsData_fill() {
        this(new ArrayList<>(), false, false, false, false);
    }

    public GuiItemsData_fill(List<Integer> slots, boolean all, boolean top, boolean border, boolean bottom) {
        this.slots = slots == null ? new ArrayList<>() : new ArrayList<>(slots);
        this.all = all;
        this.top = top;
        this.border = border;
        this.bottom = bottom;
    }

    public List<Integer> getSlots() {
        return Collections.unmodifiableList(slots);
    }

    public void setSlots(List<Integer> slots) {
        this.slots = slots == null ? new ArrayList<>() : new ArrayList<>(slots);
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    @Override
    public GuiItemsData_fill clone() {
        return new GuiItemsData_fill(slots, all, top, border, bottom);
    }
}
