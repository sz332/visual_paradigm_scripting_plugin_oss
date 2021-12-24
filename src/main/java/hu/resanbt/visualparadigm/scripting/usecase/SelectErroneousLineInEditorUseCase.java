package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;
import hu.resanbt.visualparadigm.scripting.event.ScriptExecutionFailedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class SelectErroneousLineInEditorUseCase implements UseCase {

    private final EventBus eventBus;
    private final RSyntaxTextArea textArea;

    public SelectErroneousLineInEditorUseCase(EventBus eventBus, RSyntaxTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(ScriptExecutionFailedEvent.class, this::onScriptExecutionFailed);
    }

    public void onScriptExecutionFailed(ScriptExecutionFailedEvent event) {
        SwingUtilities.invokeLater(() -> {

            try {

                if (event.hasValidLine()) {
                    var line = event.getLine();
                    textArea.setCaretPosition(textArea.getLineStartOffset(line - 1));
                    textArea.requestFocus();
                }

            } catch (BadLocationException e) {
                eventBus.publish(new ExceptionOccurredEvent(e));
            }

        });
    }

}
