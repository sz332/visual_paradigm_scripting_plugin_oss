package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryLog;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryRecord;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.DialogDisplayedEvent;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;

import javax.swing.*;
import java.util.List;

@SuppressWarnings({"squid:S3740"})
public class LoadHistoryOnDialogDisplayUseCase implements UseCase {

    private final EventBus eventBus;
    private final JComboBox comboBox;
    private final HistoryLog historyLog;

    public LoadHistoryOnDialogDisplayUseCase(EventBus eventBus, HistoryLog historyLog, JComboBox comboBox) {
        this.eventBus = eventBus;
        this.comboBox = comboBox;
        this.historyLog = historyLog;
        eventBus.subscribe(DialogDisplayedEvent.class, this::onDialogDisplayed);
    }

    @SuppressWarnings("unchecked")
    private void onDialogDisplayed(DialogDisplayedEvent event) {

        SwingUtilities.invokeLater(() -> {
            try {
                var log = historyLog.read();
                var model = new DefaultComboBoxModel<>(log.toArray(HistoryRecord[]::new));
                this.comboBox.setModel(model);
            } catch (Exception e) {
                eventBus.publish(new ExceptionOccurredEvent(e));
            }
        });
    }

}
