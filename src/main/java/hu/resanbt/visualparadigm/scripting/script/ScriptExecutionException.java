package hu.resanbt.visualparadigm.scripting.script;

public class ScriptExecutionException extends Exception {

    private final int line;

    public ScriptExecutionException(Exception e, int line) {
        super(e);
        this.line = line;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " on line " + this.line;
    }

    public int getLine() {
        return line;
    }
}
