package com.jmdb.content;

public enum TextStyle {
    REGULAR(""),
    BOLD("**"),
    ITALIC("*"),
    STRIKETHROUGH("~~");

    private final String mark;

    TextStyle(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}