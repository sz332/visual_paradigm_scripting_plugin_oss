package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.ApplicationManager;
import hu.resanbt.visualparadigm.scripting.vp.ModelHelper;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JythonScriptExecutor implements ScriptExecutor {

    @Override
    public Object execute(String script) throws ScriptExecutionException {

        try {
            PythonInterpreter interpreter = new PythonInterpreter();

            interpreter.set("app_manager", ApplicationManager.instance());
            interpreter.set("model_helper", new ModelHelper());
            interpreter.exec(script);

            PyObject result = interpreter.get("result");

            if (result == null) {
                return null;
            }

            var p2j = pythonToJava(result);

            if (p2j.isPresent()){
                return p2j.get();
            }

            if (result instanceof PyList) {
                PyList list = (PyList) result;

                var retValue = new ArrayList<>();

                for (PyObject o : list.getArray()) {
                    pythonToJava(o).ifPresent(retValue::add);
                }

                return retValue;
            }

            return result;

        } catch (Exception e) {
            throw new ScriptExecutionException(e, -1);
        }
    }

    private Optional<Object> pythonToJava(Object o){

        if (o instanceof PyInteger) {
            return Optional.of(asInteger(o));
        }

        if (o instanceof PyString) {
            return Optional.of(asString(o));
        }

        if (o instanceof PyBoolean){
            return Optional.of(asBoolean(o));
        }

        return Optional.empty();
    }

    private Integer asInteger(Object o) {
        return ((PyInteger) o).getValue();
    }

    private String asString(Object o) {
        return ((PyString) o).getString();
    }

    private Boolean asBoolean(Object o){
        return ((PyBoolean)o).getBooleanValue();
    }

}
