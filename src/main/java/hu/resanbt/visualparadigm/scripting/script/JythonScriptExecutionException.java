package hu.resanbt.visualparadigm.scripting.script;

public class JythonScriptExecutionException extends ScriptExecutionException{

    public JythonScriptExecutionException(Exception e) {
        super(e, -1);
    }
}
