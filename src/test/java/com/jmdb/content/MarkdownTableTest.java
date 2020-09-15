package com.jmdb.content;

import com.jmdb.content.table.MarkdownTable;
import com.jmdb.exceptions.MarkdownTableSizeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MarkdownTableTest {

    @Test
    public void addColumn_addNewColumnToTable_assertMustTrue() {
        // Arrange
        MarkdownTable markdownTable = new MarkdownTable(new String[]{"A","B","C"});
        String[] expectedTitles = {"A","B","C","D"};

        // Act
        markdownTable.addColumn("D", new Object[]{});
        String[] actualTitles = markdownTable.getTitles();

        // Assert
        Assert.assertArrayEquals(expectedTitles, actualTitles);
    }

    @Test(expected = MarkdownTableSizeException.class)
    public void addColumn_addNewColumnToTableWithInvalidLength_assertMustBeThrownMarkdownTableException() {
        // Arrange
        MarkdownTable markdownTable = new MarkdownTable(new String[]{"A","B","C"});
        markdownTable.addRow(new Object[]{"1","2","3"});
        markdownTable.addRow(new Object[]{"4","5","6"});

        // Act
        markdownTable.addColumn("D", new Object[]{"9","8", "8"});
    }
}
