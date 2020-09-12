package com.jmdb.content.paragprah;

import com.jmdb.MarkdownConversion;
import com.jmdb.content.TextStyle;

public class MarkdownParagraph implements MarkdownConversion {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public MarkdownParagraph(String paragraph) {
        this(paragraph, TextStyle.REGULAR);
    }


    public MarkdownParagraph(String paragraph, TextStyle textStyle) {
        String marks = "";
        switch (textStyle) {
            case BOLD:
                marks = "**";
                break;
            case ITALIC:
                marks = "*";
                break;
            case STRIKETHROUGH:
                marks = "~~";
                break;
            case REGULAR: break;
        }
        text = marks+paragraph+marks;
    }

    public MarkdownParagraph emphasize(TextStyle style) {
        text = style.getMark() + text + style.getMark();
        return this;
    }


    @Override
    public String getAsMarkdown() {
        return text+'\n';
    }

    @Override
    public String toString() {
        return "MarkdownParagraph{"+text+"}";
    }
}
