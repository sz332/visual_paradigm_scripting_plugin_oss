package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultGridFocusRequestedEvent;

import javax.swing.*;

public class FocusOnResultGridWhenRequestedUseCase implements UseCase {

    private final JTabbedPane tabbedPane;

    public FocusOnResultGridWhenRequestedUseCase(EventBus eventBus, JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
        eventBus.subscribe(ResultGridFocusRequestedEvent.class, this::onResultGridFocusRequested);
    }

    private void onResultGridFocusRequested(ResultGridFocusRequestedEvent event) {
        SwingUtilities.invokeLater(() -> this.tabbedPane.setSelectedIndex(0));
    }

}
