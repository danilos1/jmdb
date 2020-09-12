package com.jmdb.content.lists;

public class ListItem {
    private Object item;

    public ListItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
