package hu.resanbt.visualparadigm.scripting.script;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ScriptExecutionException extends Exception {

    public static final int MISSING_LINE = -1;

    private final int line;

    public ScriptExecutionException(Exception e, int line) {
        super(e);
        this.line = line;
    }

    public String getErrorMessage() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        printStackTrace(pw);

        return sw + "\n" + "on line = " + this.getLine();
    }

    public int getLine() {
        return line;
    }
}
