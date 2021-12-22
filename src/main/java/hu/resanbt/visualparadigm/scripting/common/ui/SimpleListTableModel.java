package hu.resanbt.visualparadigm.scripting.common.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

@SuppressWarnings("squid:S1948")
public class SimpleListTableModel extends AbstractTableModel {

    private final List<Object> list;

    public SimpleListTableModel(List<Object> list) {
        super();
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object item = list.get(rowIndex);
        return item != null ? item.toString() : "<null>";
    }

    @Override
    public String getColumnName(int column) {
        return "Result";
    }
}
