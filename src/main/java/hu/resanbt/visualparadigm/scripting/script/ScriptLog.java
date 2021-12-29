package hu.resanbt.visualparadigm.scripting.script;

import java.util.List;

public class ScriptLog {

    private final List<String> messages;

    public ScriptLog(List<String> messages){
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public boolean isEmpty(){
        return this.messages.isEmpty();
    }

}
