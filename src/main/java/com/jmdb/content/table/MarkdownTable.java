package com.jmdb.content.table;

import com.jmdb.core.MarkdownConversion;
import com.jmdb.exceptions.MarkdownTableSizeException;
import com.jmdb.exceptions.MarkdownTableTypeException;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * <code>Table</code> class is used as a data structure. It's kinda of plain database with
 * <i>CRUD</i> functionality. It allows you to store, add, insert, etc. rows and columns. Each <code>Table</code>
 * instance has table title, description and two-dimensional data array. Also, you can print out each table in a
 * good-looking form. Type of a column is defined when you add the first row, so the sequential types will be defined as
 * a previous ones.
 */
public class MarkdownTable implements MarkdownConversion {
    private Object[][] data;
    private String[] titles;
    private int row, col;
    private TableAlign[] aligns;


    /**
     * Receives all table data as two-dimensional array (column titles are not included to).
     * @return two-dimensional array underlying of a table
     */
    public Object[][] getData() {
        return data;
    }


    /**
     * Receives a quantity of table rows.
     * @return number of table rows
     */
    public int getRowDimensions() {
        return row;
    }


    /**
     * Receives a quantity of table columns.
     * @return number of table columns
     */
    public int getColumnDimensions() {
        return col;
    }


    /**
     * Constructs a new {@link MarkdownTable} instance, receives an array of column titles as {@link String} objects.
     * The initial capacity of data array 15 by 15 next size will increase or decrease, according to adding or removing rows or columns.
     * @param titles is an array of columns titles, also it's defined an initial number of columns
     */
    public MarkdownTable(String[] titles) {
        this.titles = titles;
        this.col = titles.length;
        this.aligns = new TableAlign[titles.length];
        Arrays.fill(aligns, TableAlign.LEFT);
        data = new Object[15][15];
    }

    /**
     * Receives a table element by <code>rowIdx</code> and <code>colIdx</code> indexes.
     * @param rowIdx it is an index of a row
     * @param colIdx it is an index of a column
     * @return table element by <code>rowIdx</code> and <code>colIdx</code> indexes
     */
    public Object get(int rowIdx, int colIdx) {
        if (rowIdx >= row || colIdx >= col) {
            throw new IndexOutOfBoundsException();
        }

        return data[rowIdx][colIdx];
    }

    /**
     * Receives array of table elements by entire row by <code>rowIdx</code> position.
     * @param rowIdx it is an index of a row array
     * @return array of table elements by entire row by <code>rowIdx</code> position
     */
    public Object[] getRow(int rowIdx) {
        if (rowIdx >= row)
            throw new IndexOutOfBoundsException();

        Object[] rows = new Object[col];
        if (col >= 0) System.arraycopy(data[rowIdx], 0, rows, 0, col);

        return rows;
    }


    /**
     * Receives array of table elements by entire column by <code>colIdx</code> position.
     * @param colIdx it is an index of a column array
     * @return array of table elements by entire column by <code>colIdx</code> position
     */
    public Object[] getColumn(int colIdx) {
        if (colIdx >= col)
            throw new IndexOutOfBoundsException();

        Object[] column = new Object[row];
        for (int i = 0; i < row; i++) {
            column[i] = data[i][colIdx];
        }

        return column;
    }


    /**
     * Receives array of table elements by entire column by <code>title</code>.
     * @param title it is name of a column
     * @return array of table elements by entire column by <code>title</code>
     */
    public Object[] getColumn(String title) {
        int colIdx = -1;
        for (int i = 0; i < titles.length; i++) {
            if (title.equalsIgnoreCase(titles[i])) {
                colIdx = i;
                break;
            }
        }

        if (colIdx == -1)
            throw new NoSuchElementException("Cannot find a title '"+title+"'");

        Object[] column = new Object[row];
        for (int i = 0; i < row; i++) {
            column[i] = data[i][colIdx];
        }

        return column;
    }

    /**
     * TODO
     * Receives {@link MarkdownTable} element, searching by <code>title</code> and <code>pos</code>
     * @param title it's a column title
     * @param pos - position of a row
     * @return table element if it exists, else throws {@link NoSuchElementException} exception.
     * @see NoSuchElementException
     */
    public Object get(String title, int pos) {
        return null;
    }


    /**
     * Receives array of columns titles.
     * @return array of all column titles of a table
     */
    public String[] getTitles() {
        return titles;
    }

    @Override
    public String toString() {
        return "MarkdownTable{"+getRowDimensions()+"x"+getColumnDimensions()+"}";
    }

    /**
     * Added a new row to a table.
     * @param r array of new row, its length must be equaled to <code>col</code>
     * @throws MarkdownTableSizeException if number of specified array <code>r</code> doesn't equals to column dimension
     * @throws MarkdownTableTypeException if <code>r</code> array has elements with defined column types
     * @see MarkdownTableSizeException
     */
    public MarkdownTable addRow(Object[] r) {
        if (r.length != col)
            throw new MarkdownTableSizeException("Number of specified array is not equaled to column dimension. Expected: "
                    +col+", but founded: "+r.length);
        checkSize();
        data[row++] = r;
        return this;
    }

    private void checkSize() {
        int size = data.length;
        if (row == size || col == size) {
            Object[][] temp = new Object[size + (size >> 1)][size + (size >> 1)];
            for (int i = 0; i < size; i++) {
                System.arraycopy(data[i], 0, temp[i], 0, data[i].length);
            }
            data = temp;
        }
    }


    /**
     * Added a new column to a table.
     * @param objects array of new column, its length must be equaled to <code>row</code>
     */
    public void addColumn(Object[] objects) {

    }

    @Override
    public String toMarkdown() {
        StringBuilder sb = new StringBuilder();

        int[] columnLengths = new int[col];
        for (int i = 0; i < col; i++) {
            int maxLength = String.valueOf(data[0][i]).length();
            for (int j = 1; j < row; j++) {
                int cur = String.valueOf(data[j][i]).length();
                if (Math.abs(cur) > Math.abs(maxLength)) maxLength = cur;
            }
            columnLengths[i] = maxLength + 1;
        }

        for (int i = 0; i < columnLengths.length; i++) {
            int titleLen = titles[i].length();
            int colLen = columnLengths[i];
            columnLengths[i] = colLen & ((titleLen - colLen) >> 31) | titleLen & (~(titleLen - colLen) >> 31);
        }


        sb.append("|");
        for (int i = 0; i < columnLengths.length; i++) {
            String format = " %-"+(columnLengths[i]+1)+"s|";
            sb.append(String.format(format, titles[i]));
        }
        sb.append("\n");
        for (int i = 0; i < columnLengths.length; i++) {
            sb.append(aligns[i].getAlign());
            for (int j = 0; j < columnLengths[i] - 3; j++) {
                sb.append(" ");
            }
        }
        sb.append("|\n");
        for (int i = 0; i < row; i++) {
            sb.append("| ");
            for (int j = 0; j < col; j++) {
                String format = "%-"+(columnLengths[j])+"s | ";
                sb.append(String.format(format, data[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public MarkdownConversion setAligns(TableAlign... aligns) {
        if (aligns.length > this.aligns.length) {
            throw new MarkdownTableSizeException("Aligns length does not match to current table columns' dimension");
        }
        for (int i = 0; i < aligns.length; i++) {
            this.aligns[i] = aligns[i];
        }
        return this;
    }
}
