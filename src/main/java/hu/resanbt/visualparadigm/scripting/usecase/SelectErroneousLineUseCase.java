package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;
import hu.resanbt.visualparadigm.scripting.event.ScriptExecutionFailedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class SelectErroneousLineUseCase implements UseCase {

    private final EventBus eventBus;
    private final RSyntaxTextArea textArea;

    public SelectErroneousLineUseCase(EventBus eventBus, RSyntaxTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(ScriptExecutionFailedEvent.class, this::onScriptExecutionFailed);
    }

    public void onScriptExecutionFailed(ScriptExecutionFailedEvent event) {
        SwingUtilities.invokeLater(() -> {

            try {
                int line = event.getLine();
                textArea.setCaretPosition(textArea.getLineStartOffset(line));
                textArea.requestFocus();
            } catch (BadLocationException e) {
                eventBus.publish(new ExceptionOccurredEvent(e));
            }

        });
    }

}
