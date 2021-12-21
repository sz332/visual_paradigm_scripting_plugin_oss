package hu.resanbt.visualparadigm.scripting.script;

import org.codehaus.groovy.control.MultipleCompilationErrorsException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyScriptExecutionException extends ScriptExecutionException{

    private static final String TEMP_FILENAME = "Script1.groovy";

    public GroovyScriptExecutionException(Exception e){
        super(e, calculateLineNumberFromException(e));
    }

    private static int calculateLineNumberFromException(Exception ex){
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

        return lineNumber;
    }

}
