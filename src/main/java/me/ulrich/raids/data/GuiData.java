package me.ulrich.raids.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class GuiData {

    private final String id;
    private final String title;
    private final int rows;
    private final int pageSize;
    private final String openSound;
    private final Map<String, GuiItemsData> items;

    public GuiData(String id, String title, int rows, int pageSize, String openSound, Map<String, GuiItemsData> items) {
        this.id = id;
        this.title = title;
        this.rows = rows;
        this.pageSize = pageSize;
        this.openSound = openSound;
        this.items = new LinkedHashMap<>(items);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRows() {
        return rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getOpenSound() {
        return openSound;
    }

    public Map<String, GuiItemsData> getItems() {
        return items;
    }
}
