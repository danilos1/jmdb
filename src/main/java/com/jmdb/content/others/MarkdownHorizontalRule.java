package com.jmdb.content.others;

import com.jmdb.core.MarkdownConversion;
import com.jmdb.exceptions.MarkdownHorizontalRuleException;

public class MarkdownHorizontalRule implements MarkdownConversion {
    private String horizontalRule;

    public MarkdownHorizontalRule() {
        this('-', 3);
    }

    public MarkdownHorizontalRule(char c) {
        this(c, 3);
    }

    public MarkdownHorizontalRule(int quantity) {
        this('-', quantity);
    }

    public MarkdownHorizontalRule(char c, int quantity) {
        if (c == '*' || c == '-' || c == '_') {
            String m = String.valueOf(c);
            horizontalRule = m;
            for (int i = 0; i < quantity - 1; i++) {
                horizontalRule = horizontalRule.concat(m);
            }
            horizontalRule += '\n';
        } else
            throw new MarkdownHorizontalRuleException("Cannot find a symbol "+ c+ ". Expected: '*', '-' or '_'");
    }

    @Override
    public String toMarkdown() {
        return horizontalRule;
    }

    @Override
    public String toString() {
        return "MarkdownHorizontalRule{'"+horizontalRule.charAt(0)+"'}";
    }
}
