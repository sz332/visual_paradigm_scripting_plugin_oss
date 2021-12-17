package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryLog;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.AppendScriptToHistoryRequestedEvent;
import hu.resanbt.visualparadigm.scripting.event.HistoryChangedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class AppendScriptToHistoryUseCase implements UseCase {

    private final EventBus eventBus;
    private final RSyntaxTextArea textArea;
    private final HistoryLog historyLog;

    public AppendScriptToHistoryUseCase(EventBus eventBus, HistoryLog historyLog, RSyntaxTextArea textArea) {
        this.eventBus = eventBus;
        this.textArea = textArea;
        this.historyLog = historyLog;
        eventBus.subscribe(AppendScriptToHistoryRequestedEvent.class, this::appendScriptToHistoryRequested);
    }

    private void appendScriptToHistoryRequested(AppendScriptToHistoryRequestedEvent event) {
        historyLog.append(textArea.getText());
        eventBus.publish(new HistoryChangedEvent());
    }
}
