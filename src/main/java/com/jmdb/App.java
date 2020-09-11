package com.jmdb;

import com.jmdb.content.*;
import com.jmdb.properties.ImageAlign;
import com.jmdb.properties.ListStyle;
import com.jmdb.properties.TextStyle;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        MarkdownFile hello = new MarkdownFile("hello.md");
        MarkdownBuilder builder = new MarkdownBuilder(hello,
                new MarkdownParagraph("Hello", TextStyle.ITALIC),
                new MarkdownList(new String[]{"This", "is", "ordered", "list"}, ListStyle.ORDERED),
                new MarkdownList(new String[]{"This", "is", "unordered", "list"}, ListStyle.UNORDERED),
                new MarkdownTable(new String[]{"Goods", "Prices"}).addRow(new Object[]{"Korg Minilogue", 15322}).addRow(new Object[]{"Arturia KeyLab", 6589})
        );


        builder.append(new MarkdownHeader("JMDB is a convenient markdown parser", 4));
        builder.append(new MarkdownImage("Anonymus",
                "https://www.anti-malware.ru/files/styles/imagesize400w/public/images/source/anonymous-mask_white-bg.jpg?itok=tDET-oyd",
                ImageAlign.LEFT));
        builder.append(new MarkdownImage("Anonymus",
                new File("C:\\Users\\Danil\\Desktop\\anon.jpg"),
                ImageAlign.CENTER));
        builder.append(new MarkdownImage("Anonymus",
                "https://www.anti-malware.ru/files/styles/imagesize400w/public/images/source/anonymous-mask_white-bg.jpg?itok=tDET-oyd",
                ImageAlign.RIGHT));

        builder.build();
    }
}
