package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.ui.SimpleListTableModel;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ListResultCreatedEvent;
import hu.resanbt.visualparadigm.scripting.event.ResultGridFocusRequestedEvent;

import javax.swing.*;

public class DisplayListResultInTableUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTable table;

    public DisplayListResultInTableUseCase(EventBus eventBus, JTable table) {
        this.eventBus = eventBus;
        this.table = table;
        eventBus.subscribe(ListResultCreatedEvent.class, this::onListResultCreated);
    }

    void onListResultCreated(ListResultCreatedEvent event) {

        eventBus.publish(new ResultGridFocusRequestedEvent());

        SwingUtilities.invokeLater(() -> {
            this.table.setRowSorter(null);

            var model = new SimpleListTableModel(event.getList());
            this.table.setModel(model);

            model.fireTableDataChanged();
        });
    }

}
