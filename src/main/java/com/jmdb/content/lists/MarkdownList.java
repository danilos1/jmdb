package com.jmdb.content.lists;

import com.jmdb.MarkdownConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownList implements MarkdownConversion {
    private List<ListItem> list;
    private ListStyle listStyle;

    public MarkdownList(ListStyle listStyle, ListItem ... listItems) {
        this.listStyle = listStyle;
        list = new ArrayList<>(Arrays.asList(listItems));
    }

    public MarkdownList(ListItem... listItems) {
        this(ListStyle.UNORDERED, listItems);
    }


    public List<ListItem> getList() {
        return list;
    }


    @Override
    public String getAsMarkdown() {
        StringBuilder sb = new StringBuilder();

        if (listStyle == ListStyle.UNORDERED)
            for (int i = 0; i < list.size(); i++) {
                sb.append("- ").append(list.get(i)).append("\n");
            }
        else
            for (int i = 0; i < list.size(); i++) {
                sb.append(i+1).append(". ").append(list.get(i)).append("\n");
            }

        return sb.toString();
    }

    public int getListSize() {
        return list.size();
    }


    @Override
    public String toString() {
        return "MarkdownList{"+list.size()+"}";
    }
}
