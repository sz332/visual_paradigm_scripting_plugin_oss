package hu.resanbt.visualparadigm.scripting.vp;

import hu.resanbt.visualparadigm.scripting.common.result.CastedList;
import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;

import java.util.List;
import java.util.Map;

/**
 * This class provides helper methods used from the script dialog.
 */
public class ModelHelper {

    /**
     * Return the visual paradigm type (com.vp.plugin.model.*) of an object of exists.
     *
     * @param o
     * @return
     */
    public String getModelElementType(Object o) {
        Class<?>[] interfaces = o.getClass().getInterfaces();

        for (Class<?> implementedInterface : interfaces) {
            if (implementedInterface.getName().startsWith("com.vp.plugin.model")) {
                return implementedInterface.getName();
            }
        }

        return "<no model type>";
    }

    /**
     * @param elements
     * @return
     */
    public ListResult asListResult(List<Object> elements) {
        return new ListResult(elements);
    }

    /**
     * @param array
     * @return
     */
    public ListResult asListResult(Object[] array) {
        return new ListResult(array);
    }

    /**
     * @param list
     * @param fields
     * @return FIXME replace null pointer exception with something else
     */
    public TabularResult asTabularResult(Object list, Map<String, String> fields) {
        return new TabularResult(CastedList.of(list).orElseThrow(NullPointerException::new).asList(), fields);
    }


}
