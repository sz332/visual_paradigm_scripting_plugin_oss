package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.result.SmartTableModel;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ResultGridFocusRequestedEvent;
import hu.resanbt.visualparadigm.scripting.event.SmartGridResultCreatedEvent;

import javax.swing.*;

public class DisplaySmartGridResultInTableUseCase implements UseCase {

    private final EventBus eventBus;
    private final JTable table;

    public DisplaySmartGridResultInTableUseCase(EventBus eventBus, JTable table) {
        this.eventBus = eventBus;
        this.table = table;
        eventBus.subscribe(SmartGridResultCreatedEvent.class, this::onSmartGridResultCreated);
    }

    private void onSmartGridResultCreated(SmartGridResultCreatedEvent event) {

        eventBus.publish(new ResultGridFocusRequestedEvent());

        SwingUtilities.invokeLater(() -> {
            SmartTableModel model = new SmartTableModel(event.getSmartGridResult());
            this.table.setModel(model);
            model.fireTableDataChanged();
        });
    }


}
