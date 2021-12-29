package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.script.ScriptLog;

public class ScriptLogCreatedEvent implements Event {

    private final ScriptLog log;

    public ScriptLogCreatedEvent(ScriptLog log){
        this.log = log;
    }

    public ScriptLog getLog() {
        return log;
    }
}
