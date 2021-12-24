package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryLog;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryRecord;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;
import hu.resanbt.visualparadigm.scripting.event.HistoryChangedEvent;

import javax.swing.*;
import java.util.List;

@SuppressWarnings({"squid:S3740"})
public class RefreshHistoryOnHistoryChangeUseCase implements UseCase {

    private final EventBus eventBus;
    private final JComboBox comboBox;
    private final HistoryLog historyLog;

    public RefreshHistoryOnHistoryChangeUseCase(EventBus eventBus, HistoryLog historyLog, JComboBox comboBox) {
        this.eventBus = eventBus;
        this.comboBox = comboBox;
        this.historyLog = historyLog;
        eventBus.subscribe(HistoryChangedEvent.class, this::onHistoryChanged);
    }

    @SuppressWarnings("unchecked")
    private void onHistoryChanged(HistoryChangedEvent event) {
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
