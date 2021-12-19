package hu.resanbt.visualparadigm.scripting.script;

public interface ScriptExecutor {

    Object execute(String script) throws ScriptExecutionException;

    String getLanguage();

}
