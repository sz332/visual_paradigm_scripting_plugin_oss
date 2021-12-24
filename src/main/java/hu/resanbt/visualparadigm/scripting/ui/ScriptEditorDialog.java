package hu.resanbt.visualparadigm.scripting.ui;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.event.CloseDialogRequestedEvent;

import javax.swing.*;
import java.awt.*;

public class ScriptEditorDialog extends JDialog {

    private final transient EventBus eventBus;

    public ScriptEditorDialog(Frame parent) {
        super(parent, "Script editor", false);

        this.eventBus = new EventBus();
        eventBus.subscribe(CloseDialogRequestedEvent.class, this::closeDialogRequested);

        this.setContentPane(new ScriptEditorPanel(eventBus));
        this.pack();
    }

    private void closeDialogRequested(CloseDialogRequestedEvent event) {
        ScriptEditorDialog.this.dispose();
    }

}
