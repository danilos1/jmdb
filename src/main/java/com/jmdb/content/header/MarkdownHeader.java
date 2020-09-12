package com.jmdb.content.header;

import com.jmdb.core.MarkdownConversion;
import com.jmdb.content.text.TextStyle;

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
    public String toMarkdown() {
        String[] levels = {"# ", "## ", "### ", "#### ", "##### ", "###### "};
        String hl = levels[headerLevel - 1];
        return hl+header+'\n';
    }

    public MarkdownHeader emphasize(TextStyle style) {
        header = style.getStartMark() + header + style.getEndMark();
        return this;
    }

    @Override
    public String toString() {
        return "MarkdownHeader{"+header+", "+headerLevel+"}";
    }
}
