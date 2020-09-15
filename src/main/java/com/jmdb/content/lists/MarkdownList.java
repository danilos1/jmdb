package com.jmdb.content.lists;

import com.jmdb.core.MarkdownConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownList implements MarkdownConversion {
    private List<ListItem> listItems;
    private ListStyle listStyle;

    public MarkdownList(ListStyle listStyle, ListItem ... listItems) {
        this.listStyle = listStyle;
        this.listItems = new ArrayList<>(Arrays.asList(listItems));
    }

    public MarkdownList(ListItem... listItems) {
        this(ListStyle.UNORDERED, listItems);
    }

    public MarkdownList(List<ListItem> listItems) {
        this(listItems, ListStyle.UNORDERED);
    }

    public MarkdownList(List<ListItem> listItems, ListStyle listStyle) {
        this.listItems = listItems;
        this.listStyle = listStyle;
    }

    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    public ListStyle getListStyle() {
        return listStyle;
    }

    public void setListStyle(ListStyle listStyle) {
        this.listStyle = listStyle;
    }

    public List<ListItem> getListItems() {
        return listItems;
    }


    @Override
    public String toMarkdown() {
        StringBuilder sb = new StringBuilder();

        if (listStyle == ListStyle.UNORDERED)
            for (int i = 0; i < listItems.size(); i++) {
                sb.append("- ").append(listItems.get(i)).append("\n");
            }
        else
            for (int i = 0; i < listItems.size(); i++) {
                sb.append(i+1).append(". ").append(listItems.get(i)).append("\n");
            }

        return sb.toString();
    }

    public int getListSize() {
        return listItems.size();
    }


    @Override
    public String toString() {
        return "MarkdownList{"+ listItems.size()+"}";
    }
}
