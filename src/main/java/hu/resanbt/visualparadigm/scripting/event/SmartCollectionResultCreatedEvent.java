package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.common.result.SmartCollectionResult;

public class SmartCollectionResultCreatedEvent implements Event {

    private final SmartCollectionResult result;

    public SmartCollectionResultCreatedEvent(SmartCollectionResult result) {
        this.result = result;
    }

    public SmartCollectionResult getSmartCollectionResult() {
        return result;
    }
}
