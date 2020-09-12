package com.jmdb.content.paragprah;

import com.jmdb.MarkdownConversion;
import com.jmdb.content.CodeStyle;
import com.jmdb.content.TextStyle;

public class MarkdownText implements MarkdownConversion {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public MarkdownText(String paragraph) {
        this(paragraph, TextStyle.REGULAR);
    }


    public MarkdownText(String paragraph, TextStyle textStyle) {
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

    public MarkdownText emphasize(TextStyle style) {
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

    public MarkdownText asCode() {
        text = TextStyle.CODE.getMark() + text + TextStyle.CODE.getMark();
        return this;
    }

    public MarkdownText asCode(CodeStyle codeStyle) {
        text = TextStyle.CODE.getMark() + codeStyle +
                '\n'+ text +'\n' + TextStyle.CODE.getMark();
        return this;
    }

    public MarkdownText asBlockquote() {
        text = TextStyle.BLOCKQUOTE.getMark() + text;
        return this;
    }
}
