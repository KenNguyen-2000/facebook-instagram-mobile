package com.ngkien299.facebooklogin;

import java.io.Serializable;
import java.util.LinkedList;

public class Item implements Serializable {
    private int itemId;
    private String itemText;

    public Item(int itemId, String itemText) {
        this.itemId = itemId;
        this.itemText = itemText;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }


}
