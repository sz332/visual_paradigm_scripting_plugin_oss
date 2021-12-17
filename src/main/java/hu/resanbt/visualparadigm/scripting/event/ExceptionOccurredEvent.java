package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

public class ExceptionOccurredEvent implements Event {

    private final Exception exception;

    public ExceptionOccurredEvent(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return exception.getMessage();
    }
}

