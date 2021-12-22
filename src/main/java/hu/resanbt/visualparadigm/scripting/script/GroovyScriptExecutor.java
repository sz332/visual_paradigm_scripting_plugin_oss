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
    public Object execute(String script) throws ScriptExecutionException {

        var binding = new Binding();
        binding.setVariable("appManager", ApplicationManager.instance());
        binding.setVariable("modelHelper", new ModelHelper());
        var shell = new GroovyShell(binding);

        try {
            return shell.evaluate(script);
        } catch (Exception ex) {
            throw new GroovyScriptExecutionException(ex);
        }
    }

}
