package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryRecord;

public class HistoryRecordSelectedEvent implements Event {

    private final HistoryRecord historyRecord;

    public HistoryRecordSelectedEvent(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
    }

    public HistoryRecord getHistoryRecord() {
        return historyRecord;
    }
}
