package com.jmdb.content.table;

public enum TableAlign {
    LEFT("|:--- "),
    CENTER("|:---:"),
    RIGHT("|---: ");

    final String align;

    TableAlign(String align) {
        this.align = align;
    }

    public String getAlign() {
        return align;
    }
}
