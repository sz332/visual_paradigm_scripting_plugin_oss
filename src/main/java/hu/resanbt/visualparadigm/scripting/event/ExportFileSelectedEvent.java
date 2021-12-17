package hu.resanbt.visualparadigm.scripting.event;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;

import java.io.File;

public class ExportFileSelectedEvent implements Event {

    private final File file;

    public ExportFileSelectedEvent(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
