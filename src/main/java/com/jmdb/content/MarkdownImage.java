package com.jmdb.content;

import com.jmdb.MarkdownConversion;
import com.jmdb.properties.ImageAlign;

import java.io.File;

public class MarkdownImage implements MarkdownConversion {
    private ImageAlign align;
    private String path;
    private String alt;


    public MarkdownImage(String desc, File file, ImageAlign align) {
        this.path = file.getAbsolutePath();
        this.alt = desc;
        this.align = align;
    }

    public MarkdownImage(String alt, String URL, ImageAlign align) {
        this.path = URL;
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
                "</p>", align.name(), path, alt);
    }
}
