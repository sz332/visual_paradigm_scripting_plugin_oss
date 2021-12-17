package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

public class ScriptExecutionRequestedEvent implements Event {

    private final String script;

    public ScriptExecutionRequestedEvent(String script) {
        this.script = script;
    }

    public String getScript() {
        return script;
    }
}
