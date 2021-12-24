package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutionException;

public class ScriptExecutionFailedEvent implements Event {

    private final ScriptExecutionException exception;

    public ScriptExecutionFailedEvent(ScriptExecutionException exception) {
        this.exception = exception;
    }

    public boolean hasValidLine() {
        return exception.getLine() != ScriptExecutionException.MISSING_LINE;
    }

    public int getLine() {
        return exception.getLine();
    }

    public String getMessage() {
        return exception.getErrorMessage();
    }

}
