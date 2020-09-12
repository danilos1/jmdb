package com.jmdb.content.image;

import com.jmdb.MarkdownConversion;

import java.io.File;

public class MarkdownImage implements MarkdownConversion {
    private ImageAlign align;
    private String path;
    private String alt;

    public MarkdownImage(String alt, File file) {
        this(file, alt, ImageAlign.LEFT);
    }

    public MarkdownImage(String path, String alt) {
        this(path, alt, ImageAlign.LEFT);
    }

    public MarkdownImage(File file, String alt, ImageAlign align) {
        this(file.getAbsolutePath(), alt, align);
    }

    public MarkdownImage(String path, String alt, ImageAlign align) {
        this.path = path;
        this.alt = alt;
        this.align = align;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public String getAsMarkdown() {
        return String.format("<p align=\"%s\">\n" +
                "\t<img src=\"%s\" alt=\"%s\"/>\n" +
                "</p>\n", align.name(), path, alt);
    }
}
