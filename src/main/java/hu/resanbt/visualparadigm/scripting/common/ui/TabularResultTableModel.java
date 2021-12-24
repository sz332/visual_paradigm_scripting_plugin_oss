package hu.resanbt.visualparadigm.scripting.common.ui;

import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("squid:S1948")
public class TabularResultTableModel extends AbstractTableModel {

    private final TabularResult result;

    public TabularResultTableModel(TabularResult result) {
        super();
        this.result = result;
    }

    @Override
    public int getRowCount() {
        return result.getList().size();
    }

    @Override
    public int getColumnCount() {
        return result.getFields().size();
    }

    @Override
    public String getColumnName(int column) {
        String field = result.getFields().keySet().toArray(new String[0])[column];
        return result.getFields().get(field);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> returnValue;
        if ((columnIndex >= 0) && (columnIndex < getColumnCount())) {
            returnValue = getValueAt(0, columnIndex).getClass();
        } else {
            returnValue = Object.class;
        }
        return returnValue;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String field = result.getFields().keySet().toArray(new String[0])[columnIndex];
        Object object = result.getList().get(rowIndex);
        return result.getPropertyReader().getPropertyOrEmptyStringByName(object, field);
    }

}
