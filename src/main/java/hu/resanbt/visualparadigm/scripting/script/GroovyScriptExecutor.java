package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.ApplicationManager;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import hu.resanbt.visualparadigm.scripting.vp.ModelHelper;

public class GroovyScriptExecutor implements ScriptExecutor {

    @Override
    public String getLanguage() {
        return "Groovy";
    }

    @Override
    public ScriptExecutionResult execute(String script) throws ScriptExecutionException {

        var logger = new ScriptLogger();

        var binding = new Binding();
        binding.setVariable("appManager", ApplicationManager.instance());
        binding.setVariable("modelHelper", new ModelHelper());
        binding.setVariable("logger", logger);
        var shell = new GroovyShell(binding);

        try {
            var evaluationResult = shell.evaluate(script);
            return new ScriptExecutionResult(evaluationResult, logger.getLog());
        } catch (Exception ex) {
            throw new GroovyScriptExecutionException(ex);
        }
    }

}
