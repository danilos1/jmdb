package com.jmdb.content.link;

import com.jmdb.MarkdownConversion;

public class MarkdownLink implements MarkdownConversion {
    private String URL;
    private String text;


    public MarkdownLink(String text, String URL) {
        this.text = text;
        this.URL = URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toMarkdown() {
        return String.format("[%s](%s)%n", text, URL);
    }
}
