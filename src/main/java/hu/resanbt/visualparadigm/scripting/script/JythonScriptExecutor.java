package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.ApplicationManager;
import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import hu.resanbt.visualparadigm.scripting.vp.ModelHelper;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JythonScriptExecutor implements ScriptExecutor {

    @Override
    public String getLanguage() {
        return "Python";
    }

    @Override
    public Object execute(String script) throws ScriptExecutionException {

        try {
            PythonInterpreter interpreter = new PythonInterpreter();

            interpreter.set("app_manager", ApplicationManager.instance());
            interpreter.set("model_helper", new ModelHelper());
            interpreter.exec(script);

            var result = interpreter.get("result");

            if (result == null) {
                return null;
            }

            // FIXME make it readable
            var p2j = pythonBaseTypeToJava(result);

            if (p2j.isPresent()){
                return p2j.get();
            } else if (result instanceof PyObjectDerived){
                return pythonObjectDerivedToJava((PyObjectDerived) result);
            } else if (result instanceof PyList) {
                return pythonListToJava((PyList) result);
            } else {
                return result;
            }

        } catch (Exception e) {
            throw new JythonScriptExecutionException(e);
        }
    }

    private Object pythonObjectDerivedToJava(PyObjectDerived derived){
        var pythonResult = derived.__tojava__(Object.class);

        if (pythonResult instanceof ListResult || pythonResult instanceof  TabularResult){
            return pythonResult;
        }

        return "Result type: " + pythonResult.getClass() + " not supported";
    }

    private List<Object> pythonListToJava(PyList list){

        var retValue = new ArrayList<>();

        for (PyObject o : list.getArray()) {
            pythonBaseTypeToJava(o).ifPresent(retValue::add);
        }

        return retValue;
    }

    private Optional<Object> pythonBaseTypeToJava(Object o){

        if (o instanceof PyInteger) {
            return Optional.of(((PyInteger) o).getValue());
        }

        if (o instanceof PyString) {
            return Optional.of(((PyString) o).getString());
        }

        if (o instanceof PyBoolean){
            return Optional.of(((PyBoolean)o).getBooleanValue());
        }

        return Optional.empty();
    }

}
