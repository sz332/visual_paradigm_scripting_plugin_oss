package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultTextareaFocusRequestedEvent;
import hu.resanbt.visualparadigm.scripting.event.ScriptExecutionFailedEvent;

import javax.swing.*;

public class DisplayScriptExecutionFailedInOutputTextAreaUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTextArea textArea;

    public DisplayScriptExecutionFailedInOutputTextAreaUseCase(EventBus eventBus, JTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(ScriptExecutionFailedEvent.class, this::onScriptExecutionFailed);
    }

    public void onScriptExecutionFailed(ScriptExecutionFailedEvent event) {
        eventBus.publish(new ResultTextareaFocusRequestedEvent());
        SwingUtilities.invokeLater(() -> textArea.setText(event.getMessage()));
    }

}
