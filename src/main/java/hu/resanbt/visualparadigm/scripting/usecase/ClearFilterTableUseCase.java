package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ClearFilterRequestedEvent;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class ClearFilterTableUseCase implements UseCase {

    private final JTable table;

    public ClearFilterTableUseCase(EventBus eventBus, JTable table) {
        this.table = table;
        eventBus.subscribe(ClearFilterRequestedEvent.class, this::clearFilterRequested);
    }

    private void clearFilterRequested(ClearFilterRequestedEvent event) {

        SwingUtilities.invokeLater(() -> {
            var sorter = new TableRowSorter<>(table.getModel());
            sorter.setRowFilter(null);
            table.setRowSorter(sorter);
        });
    }

}
