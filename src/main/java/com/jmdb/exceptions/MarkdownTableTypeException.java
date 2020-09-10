package com.jmdb.exceptions;

import com.jmdb.content.MarkdownTable;

/**
 * <code>TableTypeException</code> is used to indicate if user have problems with column types definition.
 * @see MarkdownTable#addRow(Object[])
 * @see MarkdownTable#addColumn(Object[])
 */
public class MarkdownTableTypeException extends RuntimeException{
    public MarkdownTableTypeException(String message) {
        super(message);
    }
}
