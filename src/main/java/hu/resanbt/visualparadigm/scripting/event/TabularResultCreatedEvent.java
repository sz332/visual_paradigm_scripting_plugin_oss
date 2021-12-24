package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;

public class TabularResultCreatedEvent implements Event {

    TabularResult result;

    public TabularResultCreatedEvent(TabularResult result) {
        this.result = result;
    }

    public TabularResult getTabularResult() {
        return result;
    }

}
