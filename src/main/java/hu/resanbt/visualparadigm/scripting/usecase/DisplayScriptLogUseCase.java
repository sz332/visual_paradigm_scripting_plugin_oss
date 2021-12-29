package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ScriptLogCreatedEvent;

import javax.swing.*;
import java.util.stream.Collectors;

public class DisplayScriptLogUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTextArea textArea;

    public DisplayScriptLogUseCase(EventBus eventBus, JTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        eventBus.subscribe(ScriptLogCreatedEvent.class, this::onStringResultCreated);
    }

    public void onStringResultCreated(ScriptLogCreatedEvent event) {
        SwingUtilities.invokeLater(() -> {
            var messages = event.getLog().getMessages();
            var text = messages.stream().collect(Collectors.joining("\n"));
            textArea.setText(text);
        });
    }

}
