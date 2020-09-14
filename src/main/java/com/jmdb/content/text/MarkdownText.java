package com.jmdb.content.text;

import com.jmdb.core.MarkdownBuilder;
import com.jmdb.core.MarkdownConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarkdownText implements MarkdownConversion {
    private List<String> textList;

    public void setText(String text)
    {
        textList = new ArrayList<>(Collections.singletonList(text));
    }

    public MarkdownText append(String newText) {
        textList.add(newText);
        return this;
    }

    public MarkdownText(String text) {
        this(text, TextStyle.REGULAR);
    }


    public MarkdownText(String text, TextStyle textStyle) {
        textList = new ArrayList<>(Collections.singletonList(textStyle.getStartMark() + text + textStyle.getEndMark()));
    }

    public MarkdownText setTextStyle(TextStyle style) {
        textList.add(0, style.getStartMark());
        textList.add(style.getEndMark());
        return this;
    }


    @Override
    public String toMarkdown()
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < textList.size(); i++) {
            s.append(textList.get(i)).append(" ");
        }
        return s.toString()+'\n';
    }

    @Override
    public String toString() {
        return "MarkdownParagraph{"+textList+"}";
    }


    public MarkdownText asCode(CodeStyle codeStyle) {
        textList.add(0, TextStyle.CODE.getStartMark() + codeStyle + '\n');
        textList.add(TextStyle.CODE.getEndMark());
        return this;
    }

    public MarkdownText emphasize(TextStyle textStyle) {
        int last = textList.size() - 1;
        textList.set(last, textStyle.getStartMark() + textList.get(last).trim() + textStyle.getEndMark());
        return this;
    }
}
