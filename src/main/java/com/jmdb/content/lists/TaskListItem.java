package com.jmdb.content.lists;

public class TaskListItem extends ListItem {
    private boolean state;

    public TaskListItem(Object item, boolean state) {
        super(item);
        this.state = state;
    }

    public TaskListItem(Object item) {
        super(item);
        this.state = false;
    }

    @Override
    public String toString() {
        char c = (state) ? 'x' : ' ';
        return "["+c+"] "+super.toString();
    }
}
