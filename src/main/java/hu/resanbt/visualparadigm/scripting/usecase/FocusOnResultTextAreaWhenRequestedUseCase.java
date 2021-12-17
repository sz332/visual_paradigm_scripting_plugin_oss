package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultTextareaFocusRequestedEvent;

import javax.swing.*;

public class FocusOnResultTextAreaWhenRequestedUseCase implements UseCase {

    private final JTabbedPane tabbedPane;

    public FocusOnResultTextAreaWhenRequestedUseCase(EventBus eventBus, JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
        eventBus.subscribe(ResultTextareaFocusRequestedEvent.class, this::onResultTextareaFocusRequested);
    }

    private void onResultTextareaFocusRequested(ResultTextareaFocusRequestedEvent event) {
        SwingUtilities.invokeLater(() -> this.tabbedPane.setSelectedIndex(1));
    }

}
