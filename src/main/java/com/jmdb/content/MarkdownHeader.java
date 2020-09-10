package com.jmdb.content;

import com.jmdb.MarkdownConversion;

public class MarkdownHeader implements MarkdownConversion {
    private final int headerLevel;
    private String header;

    public MarkdownHeader(String header, int headerLevel) {
        if (headerLevel <= 0 || headerLevel > 6) {
            throw new IllegalArgumentException("Header level must be equal between 1 and 6, inclusively. Found: "
                    +headerLevel);
        }
        this.headerLevel = headerLevel;
        this.header = header;
    }

    @Override
    public String getAsMarkdown() {
        String[] levels = {"# ", "## ", "### ", "#### ", "##### ", "###### "};
        String hl = levels[headerLevel - 1];
        return hl+header;
    }

    @Override
    public String toString() {
        return "MarkdownHeader{"+header+", "+headerLevel+"}";
    }
}
