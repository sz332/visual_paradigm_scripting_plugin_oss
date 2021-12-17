package hu.resanbt.visualparadigm.scripting.vp;

import com.vp.plugin.model.IModelElement;
import hu.resanbt.visualparadigm.scripting.common.result.CastedList;
import hu.resanbt.visualparadigm.scripting.common.result.SmartCollectionResult;
import hu.resanbt.visualparadigm.scripting.common.result.SmartGridResult;

import java.util.Collection;
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
    public SmartCollectionResult asSmartCollection(Collection<IModelElement> elements) {
        return new SmartCollectionResult(elements);
    }

    /**
     * @param array
     * @return
     */
    public SmartCollectionResult asSmartCollection(IModelElement[] array) {
        return new SmartCollectionResult(array);
    }

    /**
     * @param list
     * @param fields
     * @return
     */
    public SmartGridResult asSmartGrid(Object list, Map<String, String> fields) {
        return new SmartGridResult(CastedList.of(list).orElseThrow(NullPointerException::new).asList(), fields);
    }

}
