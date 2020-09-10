package com.jmdb;

import com.jmdb.content.MarkdownHeader;
import com.jmdb.content.MarkdownList;
import com.jmdb.content.MarkdownParagraph;
import com.jmdb.content.MarkdownTable;
import com.jmdb.properties.ListStyle;
import com.jmdb.properties.TextStyle;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        MarkdownFile hello = new MarkdownFile("/home/danoon/IdeaProjects/jmdb/src/main/java/com/jmdb/hello.md");
        MarkdownBuilder builder = new MarkdownBuilder(hello,
                new MarkdownParagraph("Hello", TextStyle.ITALIC),
                new MarkdownList(new String[]{"This", "is", "ordered", "list"}, ListStyle.ORDERED),
                new MarkdownList(new String[]{"This", "is", "unordered", "list"}, ListStyle.UNORDERED),
                new MarkdownTable(new String[]{"Goods", "Prices"}).addRow(new Object[]{"Korg Minilogue", 15322}).addRow(new Object[]{"Arturia KeyLab", 6589})
        );


        builder.add(new MarkdownHeader("JMDB is a convenient markdown parser", 4));

        builder.build();
    }
}
