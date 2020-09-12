package com.jmdb;

import com.jmdb.content.CodeStyle;
import com.jmdb.content.TextStyle;
import com.jmdb.content.header.MarkdownHeader;
import com.jmdb.content.image.MarkdownImage;
import com.jmdb.content.link.MarkdownLink;
import com.jmdb.content.lists.ListItem;
import com.jmdb.content.lists.MarkdownList;
import com.jmdb.content.lists.TaskListItem;
import com.jmdb.content.others.MarkdownHorizontalRule;
import com.jmdb.content.paragprah.MarkdownText;
import com.jmdb.content.table.MarkdownTable;
import com.jmdb.content.lists.ListStyle;
import com.jmdb.content.table.TableAlign;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class MarkdownTestApp
{
    public static void main( String[] args ) throws FileNotFoundException {
        MarkdownFile testMarkdownFile = new MarkdownFile("markdownTest.md");
        MarkdownBuilder builder = new MarkdownBuilder(
                testMarkdownFile,
                new MarkdownHeader("The first-level header", 1),
                new MarkdownText("Lorem Ipsum is simply dummy text of the printing " +
                        "and typesetting industry. Lorem Ipsum has been the industry's " +
                        "standard dummy text ever since the 1500s, when an unknown printer " +
                        "took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into " +
                        "electronic typesetting, remaining essentially unchanged. It was " +
                        "popularised in the 1960s with the release of Letraset sheets c" +
                        "ontaining Lorem Ipsum passages, and more recently with desktop " +
                        "publishing software like Aldus PageMaker including versions of " +
                        "Lorem Ipsum."),
                new MarkdownHorizontalRule(25),
                new MarkdownTable(new String[]{"Syntax", "Description", "Test text"}).
                        addRow(new Object[]{"Header", "Title", "Here's this"})
                        .addRow(new Object[]{"Paragraph", "Text", "And"}).setAligns(TableAlign.RIGHT, TableAlign.LEFT)

        );
        builder.append(new MarkdownList(
                ListStyle.ORDERED,
                new ListItem("Syntax"),
                new ListItem("Description"),
                new ListItem("Text")
        ));
        builder.append(new MarkdownText("This is a task list:"));
        builder.append(new MarkdownList(
                ListStyle.ORDERED,
                new TaskListItem("Syntax", true),
                new TaskListItem("Description"),
                new TaskListItem("Text", true)
        ));
        builder.append(new MarkdownText("package com.jmdb;\n" +
                "\n" +
                "import java.io.BufferedWriter;\n" +
                "import java.io.FileWriter;\n" +
                "import java.io.IOException;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.List;").asCode(CodeStyle.JAVA));
        builder.append(new MarkdownLink("My Github account", "https://github.com/danilos1"));
        builder.append(new MarkdownImage("https://specials-images.forbesimg.com/imageserve/5efc6a13531e1500073c6521/960x0.jpg?fit=scale", "Anon"));
        builder.append(
                new MarkdownText("The blockquote element is used to indicate the quotation of a large section of text from another source.")
                .asBlockquote());
        builder.append(new MarkdownText("Underlined text", TextStyle.UNDERLINED));
        builder.append(new MarkdownText("Monospaced text", TextStyle.MONOSPACED));
        builder.build();
    }
}
