package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.ApplicationManager;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import hu.resanbt.visualparadigm.scripting.vp.ModelHelper;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyScriptExecutor implements ScriptExecutor {

    private static final String TEMP_FILENAME = "Script1.groovy";

    @Override
    public Object execute(String script) throws ScriptExecutionException {

        var binding = new Binding();
        binding.setVariable("appManager", ApplicationManager.instance());
        binding.setVariable("modelHelper", new ModelHelper());
        var shell = new GroovyShell(binding);

        try {
            return shell.evaluate(script);
        } catch (Exception ex) {

            var lineNumber = -1;

            if (ex instanceof MultipleCompilationErrorsException) {
                Pattern pattern = Pattern.compile("@ line ([0-9]+)");
                Matcher matcher = pattern.matcher(ex.getMessage());

                if (matcher.find()) {
                    try {
                        lineNumber = Integer.parseInt(matcher.group(1)) - 1;
                    } catch (NumberFormatException e) {
                        lineNumber = -1;
                    }
                }

            } else {

                lineNumber = Arrays.stream(ex.getStackTrace())
                        .filter(e -> TEMP_FILENAME.equals(e.getFileName())) // matching filename
                        .map(StackTraceElement::getLineNumber) // get line number
                        .map(x -> x - 1)                       // groovy starts with line number 1, but we need it from zero
                        .findFirst()                           // find the first one
                        .orElse(-1);                     // or else set -1 meaning we have no idea

            }

            throw new ScriptExecutionException(ex, lineNumber);
        }
    }

}
