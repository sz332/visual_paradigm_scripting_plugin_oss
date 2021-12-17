package hu.resanbt.visualparadigm.scripting.common.result;

import java.util.List;
import java.util.Map;

public class SmartGridResult {

    private final List<Object> list;
    private final Map<String, String> fields;

    public SmartGridResult(List<Object> list, Map<String, String> fields) {
        this.list = list;
        this.fields = fields;
    }

    public List<Object> getList() {
        return this.list;
    }

    public Map<String, String> getFields() {
        return this.fields;
    }

}
