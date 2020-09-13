package com.jmdb.content.text;

import com.jmdb.core.MarkdownConversion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MarkdownCode implements MarkdownConversion {
    private File codeFile;
    private CodeStyle codeStyle;

    public MarkdownCode(File codeFile, CodeStyle codeStyle) {
        this.codeFile = codeFile;
        this.codeStyle = codeStyle;
    }

    public File getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(File codeFile) {
        this.codeFile = codeFile;
    }

    public CodeStyle getCodeStyle() {
        return codeStyle;
    }

    public void setCodeStyle(CodeStyle codeStyle) {
        this.codeStyle = codeStyle;
    }

    @Override
    public String toMarkdown() {
        StringBuilder codeSnippet = new StringBuilder();
        MarkdownText text;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(codeFile))) {
            String codeLine;
            while ((codeLine = bufferedReader.readLine()) != null) {
                codeSnippet.append(codeLine).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = new MarkdownText(codeSnippet.toString()).asCode(codeStyle);
        return text.toMarkdown();
    }
}
