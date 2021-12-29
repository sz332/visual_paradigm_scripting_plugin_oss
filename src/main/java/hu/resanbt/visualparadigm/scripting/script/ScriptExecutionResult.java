package hu.resanbt.visualparadigm.scripting.script;

public class ScriptExecutionResult {

    private final Object result;
    private final ScriptLog log;

    public ScriptExecutionResult(Object result, ScriptLog log){
        this.result = result;
        this.log = log;
    }

    public Object getResult() {
        return result;
    }

    public ScriptLog getLog() {
        return log;
    }
}
