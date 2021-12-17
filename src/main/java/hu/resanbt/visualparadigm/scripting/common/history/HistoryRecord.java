package hu.resanbt.visualparadigm.scripting.common.history;

public class HistoryRecord {

    private String language;
    private String script;

    public HistoryRecord() {
    }

    public HistoryRecord(String language, String script) {
        this.language = language;
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
