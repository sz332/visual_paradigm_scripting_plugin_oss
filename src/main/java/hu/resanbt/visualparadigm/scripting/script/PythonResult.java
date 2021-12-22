package hu.resanbt.visualparadigm.scripting.script;

import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import org.python.core.*;

import java.util.*;

public class PythonResult {

    private final PyObject pyObject;

    public PythonResult(PyObject pyObject){
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
            }
        }

        return list;
    }

    private Object convertPythonObjectToMap(PyInstance instance, Map<String, String> fields) {

        var properties = new HashMap<String, Object>();

        for (String key : fields.keySet()) {
            var pyObject = instance.__findattr_ex__(key);
            properties.put(key, pythonBaseTypeToJava(pyObject).orElse("<unknown type>"));
        }

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

}
