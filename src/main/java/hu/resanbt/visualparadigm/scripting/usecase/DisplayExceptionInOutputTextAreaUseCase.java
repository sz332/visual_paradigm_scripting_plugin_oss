package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;
import hu.resanbt.visualparadigm.scripting.event.ResultTextareaFocusRequestedEvent;

import javax.swing.*;

public class DisplayExceptionInOutputTextAreaUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTextArea textArea;

    public DisplayExceptionInOutputTextAreaUseCase(EventBus eventBus, JTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(ExceptionOccurredEvent.class, this::onExceptionOccurred);
    }

    public void onExceptionOccurred(ExceptionOccurredEvent event) {
        eventBus.publish(new ResultTextareaFocusRequestedEvent());
        SwingUtilities.invokeLater(() -> textArea.setText(event.getMessage()));
    }

}
