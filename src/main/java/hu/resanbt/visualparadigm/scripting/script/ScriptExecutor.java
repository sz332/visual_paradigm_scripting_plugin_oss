package hu.resanbt.visualparadigm.scripting.script;

public interface ScriptExecutor {

    ScriptExecutionResult execute(String script) throws ScriptExecutionException;

    String getLanguage();

}
