package com.jmdb.content.shileds;

import com.jmdb.MarkdownConversion;

public class MarkdownShield implements MarkdownConversion {
    private String label;
    private String message;
    private String color;
    private String URL;

    public MarkdownShield(String label, String message, String color, String URL) {
        this.label = label;
        this.message = message;
        this.color = color;
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toMarkdown() {
        return String.format("[![%s: %s](https://img.shields.io/badge/%s-%s-%s.svg)](%s)",
                label, message, label, message, color, URL);
    }
}
