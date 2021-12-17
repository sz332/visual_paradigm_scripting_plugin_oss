package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.common.result.SmartGridResult;

public class SmartGridResultCreatedEvent implements Event {

    SmartGridResult result;

    public SmartGridResultCreatedEvent(SmartGridResult result) {
        this.result = result;
    }

    public SmartGridResult getSmartGridResult() {
        return result;
    }

}
