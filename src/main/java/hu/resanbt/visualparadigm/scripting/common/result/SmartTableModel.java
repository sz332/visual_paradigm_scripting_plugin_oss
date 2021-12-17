package hu.resanbt.visualparadigm.scripting.common.result;

import hu.resanbt.visualparadigm.scripting.common.reflection.Bean;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("squid:S1948")
public class SmartTableModel extends AbstractTableModel {

    private final SmartGridResult grid;

    public SmartTableModel(SmartGridResult grid) {
        super();
        this.grid = grid;
    }

    @Override
    public int getRowCount() {
        return grid.getList().size();
    }

    @Override
    public int getColumnCount() {
        return grid.getFields().size();
    }

    @Override
    public String getColumnName(int column) {
        String field = grid.getFields().keySet().toArray(new String[0])[column];
        return grid.getFields().get(field);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String field = grid.getFields().keySet().toArray(new String[0])[columnIndex];
        Object object = grid.getList().get(rowIndex);
        return Bean.of(object).propertyOrEmptyString(field);
    }

}
