package hu.resanbt.visualparadigm.scripting.script;

import hu.resanbt.visualparadigm.scripting.common.result.TabularResultPropertyReader;

import java.util.Map;

public class MapTabularResultPropertyReader implements TabularResultPropertyReader {

    @Override
    public Object getPropertyByName(Object object, String name) {
        return object instanceof Map ? ((Map) object).get(name) : null;
    }

    @Override
    public Object getPropertyOrEmptyStringByName(Object object, String name) {
        Object result = getPropertyByName(object, name);
        return result == null ? "" : result;
    }

    @Override
    public String getPropertyNameAsString(Object object, String propertyName) {
        return getPropertyOrEmptyStringByName(object, propertyName).toString();
    }


}
