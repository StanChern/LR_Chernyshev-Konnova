package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelXY extends AbstractTableModel {

    public static final int INDEX_COLUMN_NUMBER = 0;
    public static final int VALUE_COLUMN_NUMBER = 1;
    private static final long serialVersionUID = 6915690567071855880L;
    private List<String> strings;

    public TableModelXY(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public int getRowCount() {
        return strings.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return rowIndex;
            case VALUE_COLUMN_NUMBER:
                return strings.get(rowIndex);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex != VALUE_COLUMN_NUMBER) {
            return;
        }
        strings.set(rowIndex, String.valueOf(aValue));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return false;
            case VALUE_COLUMN_NUMBER:
                return true;
        }

        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case INDEX_COLUMN_NUMBER:
                return "X: ";
            case VALUE_COLUMN_NUMBER:
                return "Y: ";

        }
        return super.getColumnName(column);
    }
}
