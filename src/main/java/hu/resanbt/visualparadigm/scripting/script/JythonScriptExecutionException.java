package hu.resanbt.visualparadigm.scripting.script;

import org.python.core.PyException;
import org.python.core.PySyntaxError;
import org.python.core.PyTuple;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        } else if (e instanceof PyException){

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            Pattern pattern = Pattern.compile(", line ([0-9]+)");
            Matcher matcher = pattern.matcher(sw.toString());

            if (matcher.find()) {
                try {
                    return Integer.parseInt(matcher.group(1));
                } catch (NumberFormatException nfe) {
                    return MISSING_LINE;
                }
            }
        }

        return MISSING_LINE;
    }
}
