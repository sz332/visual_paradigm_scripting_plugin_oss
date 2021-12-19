package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.FilterRequestedEvent;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class FilterTableUseCase implements UseCase {

    private final JTable table;

    public FilterTableUseCase(EventBus eventBus, JTable table) {
        this.table = table;
        eventBus.subscribe(FilterRequestedEvent.class, this::filterRequested);
    }

    private void filterRequested(FilterRequestedEvent event) {

        SwingUtilities.invokeLater(() -> {

            var sorter = new TableRowSorter<>(table.getModel());

            try {
                var rf = RowFilter.regexFilter(event.getFilter());
                sorter.setRowFilter(rf);
            } catch (Exception e) {
                return;
            }

            table.setRowSorter(sorter);
        });
    }

}
