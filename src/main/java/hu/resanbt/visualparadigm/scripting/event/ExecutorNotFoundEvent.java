package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.script.ExecutorNotFoundException;

public class ExecutorNotFoundEvent implements Event {

    private final ExecutorNotFoundException exception;

    public ExecutorNotFoundEvent(ExecutorNotFoundException exception) {
        this.exception = exception;
    }

}
