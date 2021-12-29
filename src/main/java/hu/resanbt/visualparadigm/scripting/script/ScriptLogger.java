package hu.resanbt.visualparadigm.scripting.script;

import java.util.ArrayList;
import java.util.List;

public class ScriptLogger {

    private final List<String> messages;

    public ScriptLogger(){
        this.messages = new ArrayList<>();
    }

    public void log(String message){
        messages.add(message);
    }

    public ScriptLog getLog(){
        return new ScriptLog(messages);
    }

}
