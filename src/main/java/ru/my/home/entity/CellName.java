package ru.my.home.entity;

import ru.my.home.constatnt.ColumnName;

public class CellName {

    private final int rowIndex;
    private final ColumnName columnName;

    public CellName(int rowIndex, ColumnName columnName) {
        this.rowIndex = rowIndex;
        this.columnName = columnName;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    @Override
    public String toString() {
        return "Ячейка " + columnName + rowIndex;
    }
}
