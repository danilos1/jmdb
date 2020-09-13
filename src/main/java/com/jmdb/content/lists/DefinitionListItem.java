package com.jmdb.content.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefinitionListItem extends ListItem {
    private List<Object> def;

    public DefinitionListItem(Object term, Object...def) {
        super(term);
        this.def = new ArrayList<>(Arrays.asList(def));
    }

    public List<Object> getDefinitions() {
        return def;
    }

    @Override
    public String toString() {
        return getItem()+"\n"+": "+def+"\n";
    }
}
