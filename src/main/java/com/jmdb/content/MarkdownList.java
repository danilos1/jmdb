package com.jmdb.content;

import com.jmdb.MarkdownConversion;
import com.jmdb.properties.ListStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownList implements MarkdownConversion {
    private List<String> list;
    private ListStyle listStyle;

    public MarkdownList(String[] points, ListStyle listStyle) {
        list = new ArrayList<>(Arrays.asList(points));
        this.listStyle = listStyle;
    }

    public List<String> getList() {
        return list;
    }


    @Override
    public String getAsMarkdown() {
        StringBuilder sb = new StringBuilder();

        if (listStyle == ListStyle.UNORDERED)
            for (int i = 0; i < list.size(); i++) {
                sb.append("\n- ").append(list.get(i));
            }
        else
            for (int i = 0; i < list.size(); i++) {
                sb.append("\n").append(i+1).append(". ").append(list.get(i));
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
