package com.jmdb.content.lists;

import com.jmdb.core.MarkdownConversion;

import java.util.List;

public class MarkdownDefinitionList extends MarkdownList implements MarkdownConversion {

    public MarkdownDefinitionList(DefinitionListItem... defListItems) {
        super(defListItems);
    }

    @Override
    public String toMarkdown() {
        StringBuilder listBuilder = new StringBuilder("<dl>\n");
        List<ListItem> defListItem = super.getListItems();
        for (int i = 0; i < defListItem.size(); i++) {
            DefinitionListItem d = ((DefinitionListItem) defListItem.get(i));
            listBuilder.append("\t<dt>").append(d.getItem()).append("</dt>\n");
            for (int j = 0; j < d.getDefinitions().size(); j++) {
                listBuilder.append("\t<dd>").append(d.getDefinitions().get(j)).append("</dd>\n");
            }
        }
        listBuilder.append("</dl>\n");
        return listBuilder.toString();
    }

    @Override
    public String toString() {
        return "MarkdownDefinitionList{"+super.getListSize()+"}";
    }
}
