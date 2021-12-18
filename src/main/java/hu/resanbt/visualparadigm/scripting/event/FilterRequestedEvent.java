package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

public class FilterRequestedEvent implements Event {

    private final String filter;

    public FilterRequestedEvent(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
