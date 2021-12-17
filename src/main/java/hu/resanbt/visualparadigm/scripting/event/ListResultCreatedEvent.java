package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

import java.util.List;

public class ListResultCreatedEvent implements Event {

    private final List<Object> list;

    public ListResultCreatedEvent(List<Object> list) {
        this.list = list;
    }

    public List<Object> getList() {
        return list;
    }
}
