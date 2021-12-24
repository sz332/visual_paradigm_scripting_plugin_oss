package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.model.IModelElement;
import hu.resanbt.visualparadigm.scripting.common.logging.Logger;
import hu.resanbt.visualparadigm.scripting.common.reflection.Bean;
import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResultPropertyReader;
import org.python.core.*;

import java.util.*;

/**
 * FIXME this class has a nice interface but a not very nice implementation. The implementation
 * shall be cleaned up.
 */
public class PythonResult {

    private final PyObject pyObject;

    public PythonResult(PyObject pyObject) {
        this.pyObject = pyObject;
    }

    public Object asJava() {

        if (pyObject == null) {
            return null;
        }

        var p2j = pythonBaseTypeToJava(pyObject);

        if (p2j.isPresent()) {
            return p2j.get();
        } else if (pyObject instanceof PyList) {
            return pythonListToJava((PyList) pyObject);
        } else if (pyObject instanceof PyObjectDerived) {
            return pythonObjectDerivedToJava((PyObjectDerived) pyObject);
        } else {
            return pyObject;
        }
    }

    private Object pythonObjectDerivedToJava(PyObjectDerived derived) {
        var pythonResult = derived.__tojava__(Object.class);

        if (pythonResult instanceof ListResult) {
            return pythonResult;
        }

        if (pythonResult instanceof TabularResult) {
            Logger.log("Result was type of tabularResult");
            var tabularResult = (TabularResult) pythonResult;
            return new TabularResult(tabularResultToJava(tabularResult), tabularResult.getFields(), new MapTabularResultPropertyReader());
        }

        return "Result type: " + pythonResult.getClass() + " not supported";
    }

    private List<Object> tabularResultToJava(TabularResult result) {
        var list = new ArrayList<>();

        for (var entry : result.getList()) {
            if (entry instanceof PyInstance) {
                list.add(convertPythonObjectToMap((PyInstance) entry, result.getFields()));
            } else if (entry instanceof IModelElement){
                list.add(convertVPObjectToMap(entry, result.getFields()));
            } else {
                Logger.log("Object was neither PyInstance, nor IModelElement but " + entry.getClass() + ", skipping...");
            }
        }

        return list;
    }

    private Object convertVPObjectToMap(Object instance, Map<String, String> fields){

        var properties = new HashMap<String, Object>();

        Bean bean = Bean.of(instance);

        for (String key : fields.keySet()) {
            properties.put(key, bean.propertyOrEmptyString(key));
        }

        Logger.log("VP Object converted to map = " + properties);

        return properties;
    }

    private Object convertPythonObjectToMap(PyInstance instance, Map<String, String> fields) {
        var properties = new HashMap<String, Object>();

        for (String key : fields.keySet()) {
            var pyObject = instance.__findattr_ex__(key);
            properties.put(key, pythonBaseTypeToJava(pyObject).orElse("<unknown type>"));
        }

        Logger.log("Py instance converted to map = " + properties);

        return properties;
    }

    private List<Object> pythonListToJava(PyList list) {

        var retValue = new ArrayList<>();

        for (PyObject o : list.getArray()) {
            pythonBaseTypeToJava(o).ifPresent(retValue::add);
        }

        return retValue;
    }

    private Optional<Object> pythonBaseTypeToJava(Object o) {

        if (o instanceof PyInteger) {
            return Optional.of(((PyInteger) o).getValue());
        }

        if (o instanceof PyString) {
            return Optional.of(((PyString) o).getString());
        }

        if (o instanceof PyBoolean) {
            return Optional.of(((PyBoolean) o).getBooleanValue());
        }

        return Optional.empty();
    }

    private static class MapTabularResultPropertyReader implements TabularResultPropertyReader {

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


}
