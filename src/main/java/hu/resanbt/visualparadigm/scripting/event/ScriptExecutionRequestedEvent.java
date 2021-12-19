package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

public class ScriptExecutionRequestedEvent implements Event {

    private final String language;
    private final String script;

    public ScriptExecutionRequestedEvent(String language, String script) {
        this.language = language;
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public String getScript() {
        return script;
    }
}
