package hu.resanbt.visualparadigm.scripting.common.result;

import java.util.List;
import java.util.Map;

public class TabularResult {

    private final List<Object> list;
    private final Map<String, String> fields;
    private final TabularResultPropertyReader propertyReader;

    public TabularResult(List<Object> list, Map<String, String> fields) {
        this(list, fields, new JavaBeanTabularResultPropertyReader());
    }

    public TabularResult(List<Object> list, Map<String, String> fields, TabularResultPropertyReader propertyReader) {
        this.list = list;
        this.fields = fields;
        this.propertyReader = propertyReader;
    }

    public List<Object> getList() {
        return this.list;
    }

    public Map<String, String> getFields() {
        return this.fields;
    }

    public TabularResultPropertyReader getPropertyReader() {
        return propertyReader;
    }
}
