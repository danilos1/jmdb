package com.jmdb.content.text;

import com.jmdb.core.MarkdownConversion;

public class MarkdownText implements MarkdownConversion {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public MarkdownText(String text) {
        this(text, TextStyle.REGULAR);
    }


    public MarkdownText(String text, TextStyle textStyle) {
        this.text = textStyle.getStartMark()+text+textStyle.getEndMark();
    }

    public MarkdownText emphasize(TextStyle style) {
        text = style.getStartMark() + text + style.getEndMark();
        return this;
    }


    @Override
    public String toMarkdown() {
        return text+'\n';
    }

    @Override
    public String toString() {
        return "MarkdownParagraph{"+text+"}";
    }

    public MarkdownText asCode() {
        text = TextStyle.CODE.getStartMark() + text + TextStyle.CODE.getEndMark();
        return this;
    }

    public MarkdownText asCode(CodeStyle codeStyle) {
        text = TextStyle.CODE.getStartMark() + codeStyle +
                '\n'+ text +'\n' + TextStyle.CODE.getEndMark();
        return this;
    }

    public MarkdownText asBlockquote() {
        text = TextStyle.BLOCKQUOTE.getStartMark() + text;
        return this;
    }
}
