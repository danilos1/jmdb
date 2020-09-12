package com.jmdb.exceptions;

import com.jmdb.content.table.MarkdownTable;

/**
 * <code>TableSizeException</code> is used to indicate if user have problems with row or column indexes definition or
 * definition of row and columns.
 * @see MarkdownTable#addRow(Object[])
 * @see MarkdownTable#addColumn(Object[])
 */
public class MarkdownTableSizeException extends RuntimeException {
    public MarkdownTableSizeException(String s) {
        super(s);
    }
}
