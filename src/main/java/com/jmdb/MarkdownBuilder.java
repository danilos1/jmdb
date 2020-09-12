package com.jmdb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownBuilder {
    private MarkdownFile file;
    private List<MarkdownConversion> elements;

    public MarkdownBuilder(MarkdownFile file) {
        this.file = file;
        elements = new ArrayList<>();
    }

    public MarkdownBuilder(MarkdownFile file, MarkdownConversion ... content) {
        this.file = file;
        elements = new ArrayList<>(Arrays.asList(content));
    }

    public MarkdownFile getFile() {
        return file;
    }

    public List<MarkdownConversion> getElements() {
        return elements;
    }

    public void setFile(MarkdownFile file) {
        this.file = file;
    }

    public boolean build() {
        return this.build(false);
    }

    public boolean build(boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (int i = 0; i < elements.size(); i++) {
                bufferedWriter.write(elements.get(i).toMarkdown());
                bufferedWriter.append("\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean append(MarkdownConversion element) {
        return elements.add(element);
    }

    public boolean append(char c) {
        return elements.add(() -> String.valueOf(c));
    }

    public int size() {
        return elements.size();
    }

    public MarkdownConversion get(int i) {
        return elements.get(i);
    }
}
