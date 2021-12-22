package hu.resanbt.visualparadigm.scripting.script;

import org.python.core.PySyntaxError;
import org.python.core.PyTuple;

public class JythonScriptExecutionException extends ScriptExecutionException {

    public JythonScriptExecutionException(Exception e) {
        super(e, calculateLineNumberFromException(e));
    }

    private static int calculateLineNumberFromException(Exception e) {

        if (e instanceof PySyntaxError) {
            var ex = (PySyntaxError) e;

            PyTuple tuple = (PyTuple) ex.value;

            String msg = tuple.get(0).toString();
            PyTuple loc = (PyTuple) tuple.get(1);
            return (Integer) loc.get(1);
        }

        return MISSING_LINE;
    }
}
