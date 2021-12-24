package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.ui.TabularResultTableModel;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultGridFocusRequestedEvent;
import hu.resanbt.visualparadigm.scripting.event.TabularResultCreatedEvent;

import javax.swing.*;

public class DisplayTabularResultInTableUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTable table;

    public DisplayTabularResultInTableUseCase(EventBus eventBus, JTable table) {
        this.eventBus = eventBus;
        this.table = table;
        eventBus.subscribe(TabularResultCreatedEvent.class, this::onTabularResultCreated);
    }

    private void onTabularResultCreated(TabularResultCreatedEvent event) {

        eventBus.publish(new ResultGridFocusRequestedEvent());

        SwingUtilities.invokeLater(() -> {
            this.table.setRowSorter(null);
            var model = new TabularResultTableModel(event.getTabularResult());
            this.table.setModel(model);
            model.fireTableDataChanged();
        });
    }


}
