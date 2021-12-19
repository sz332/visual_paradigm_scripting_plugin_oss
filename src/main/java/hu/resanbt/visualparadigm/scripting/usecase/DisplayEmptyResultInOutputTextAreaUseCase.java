package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.EmptyResultCreatedEvent;
import hu.resanbt.visualparadigm.scripting.event.ResultTextareaFocusRequestedEvent;

import javax.swing.*;

public class DisplayEmptyResultInOutputTextAreaUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTextArea textArea;

    public DisplayEmptyResultInOutputTextAreaUseCase(EventBus eventBus, JTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(EmptyResultCreatedEvent.class, this::onEmptyResultCreated);
    }

    public void onEmptyResultCreated(EmptyResultCreatedEvent event) {
        eventBus.publish(new ResultTextareaFocusRequestedEvent());
        SwingUtilities.invokeLater(() -> textArea.setText("Empty result provided..."));
    }

}
