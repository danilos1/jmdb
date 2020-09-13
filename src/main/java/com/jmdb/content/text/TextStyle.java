package com.jmdb.content.text;

public enum TextStyle {
    REGULAR(""),
    BOLD("**"),
    ITALIC("*"),
    STRIKETHROUGH("~~"),
    CODE("```", "```"),
    BLOCKQUOTE("> ",""),
    UNDERLINED("<ins>","</ins>"),
    MONOSPACED("<samp>","</samp>"),
    NOTE("> ***NOTE:*** ", "");

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
