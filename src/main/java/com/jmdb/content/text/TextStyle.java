package com.jmdb.content.text;

public enum TextStyle {
    REGULAR(""),
    BOLD("<b>", "</b>"),
    ITALIC("<i>","</i>"),
    STRIKETHROUGH("~~"),
    CODE("```", "\n```"),
    BLOCKQUOTE("> ",""),
    UNDERLINED("<ins>","</ins>"),
    MONOSPACED("<samp>","</samp>"),
    KEYBOARD("<kbd>","</kbd>"),
    NOTE("<table><td><blockquote><i><b>NOTE: </b></i>", "</blockquote></td></table>");

    private final String startMark;
    private final String endMark;

    TextStyle(String mark) {
        this(mark, mark);
    }

    TextStyle(String startMark, String endMark) {
        this.startMark = startMark;
        this.endMark = endMark;
    }

    public String getStartMark() {
        return startMark;
    }

    public String getEndMark() {
        return endMark;
    }
}
