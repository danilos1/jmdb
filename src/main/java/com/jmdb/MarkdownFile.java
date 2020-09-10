package com.jmdb;

import com.jmdb.exceptions.MarkdownInvalidFileFormatException;

import java.io.File;

public class MarkdownFile extends File{
    private File file;


    public MarkdownFile(String pathname) {
        super(pathname);
        if (!pathname.matches(".+\\.md")) {
            throw new MarkdownInvalidFileFormatException("The file format does not match to markdown file format");
        }
        this.file = new File(pathname);
    }


    public File getFile() {
        return file;
    }


    public void setFile(File file) {
        this.file = file;
    }
}
