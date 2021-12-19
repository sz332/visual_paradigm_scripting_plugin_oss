package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultTextareaFocusRequestedEvent;
import hu.resanbt.visualparadigm.scripting.event.StringResultCreatedEvent;

import javax.swing.*;

public class DisplayStringResultInOutputTextAreaUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTextArea textArea;

    public DisplayStringResultInOutputTextAreaUseCase(EventBus eventBus, JTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(StringResultCreatedEvent.class, this::onStringResultCreated);
    }

    public void onStringResultCreated(StringResultCreatedEvent event) {
        eventBus.publish(new ResultTextareaFocusRequestedEvent());
        SwingUtilities.invokeLater(() -> textArea.setText(event.getResult()));
    }

}
