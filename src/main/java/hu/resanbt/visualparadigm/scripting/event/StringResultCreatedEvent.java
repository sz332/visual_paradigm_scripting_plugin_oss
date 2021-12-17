package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

public class StringResultCreatedEvent implements Event {

    String result;

    public StringResultCreatedEvent(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
