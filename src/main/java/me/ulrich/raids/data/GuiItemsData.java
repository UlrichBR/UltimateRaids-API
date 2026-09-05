package me.ulrich.raids.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * GUI item model following the UltimateClans-style configuration contract.
 */
public class GuiItemsData implements Cloneable {

    private String id;
    private String page;
    private String clickSound;
    private int amount = 1;
    private String material = "STONE";
    private boolean glow;
    private String name = " ";
    private List<String> lore = new ArrayList<>();
    private String texture = "";
    private NbtData nbt = new NbtData();
    private int slot = -1;
    private GuiItemsData_fill mimeSlots = new GuiItemsData_fill();
    private List<String> leftActions = new ArrayList<>();
    private List<String> rightActions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getClickSound() {
        return clickSound;
    }

    public void setClickSound(String clickSound) {
        this.clickSound = clickSound;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isGlow() {
        return glow;
    }

    public void setGlow(boolean glow) {
        this.glow = glow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return Collections.unmodifiableList(lore);
    }

    public void setLore(List<String> lore) {
        this.lore = lore == null ? new ArrayList<>() : new ArrayList<>(lore);
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public NbtData getNbt() {
        return nbt;
    }

    public void setNbt(NbtData nbt) {
        this.nbt = nbt == null ? new NbtData() : nbt;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public GuiItemsData_fill getMimeSlots() {
        return mimeSlots;
    }

    public void setMimeSlots(GuiItemsData_fill mimeSlots) {
        this.mimeSlots = mimeSlots == null ? new GuiItemsData_fill() : mimeSlots;
    }

    public List<String> getLeftActions() {
        return Collections.unmodifiableList(leftActions);
    }

    public void setLeftActions(List<String> leftActions) {
        this.leftActions = leftActions == null ? new ArrayList<>() : new ArrayList<>(leftActions);
    }

    public List<String> getRightActions() {
        return Collections.unmodifiableList(rightActions);
    }

    public void setRightActions(List<String> rightActions) {
        this.rightActions = rightActions == null ? new ArrayList<>() : new ArrayList<>(rightActions);
    }

    @Override
    public GuiItemsData clone() {
        GuiItemsData clone = new GuiItemsData();
        clone.id = id;
        clone.page = page;
        clone.clickSound = clickSound;
        clone.amount = amount;
        clone.material = material;
        clone.glow = glow;
        clone.name = name;
        clone.lore = new ArrayList<>(lore);
        clone.texture = texture;
        clone.nbt = nbt == null ? new NbtData() : nbt.clone();
        clone.slot = slot;
        clone.mimeSlots = mimeSlots == null ? new GuiItemsData_fill() : mimeSlots.clone();
        clone.leftActions = new ArrayList<>(leftActions);
        clone.rightActions = new ArrayList<>(rightActions);
        return clone;
    }
}
