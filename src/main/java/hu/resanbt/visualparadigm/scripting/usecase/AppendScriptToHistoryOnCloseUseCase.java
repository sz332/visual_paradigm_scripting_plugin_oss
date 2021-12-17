package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryLog;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.CloseDialogRequestedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class AppendScriptToHistoryOnCloseUseCase implements UseCase {

    private final RSyntaxTextArea textArea;
    private final HistoryLog historyLog;

    public AppendScriptToHistoryOnCloseUseCase(EventBus eventBus, HistoryLog historyLog, RSyntaxTextArea textArea) {
        this.textArea = textArea;
        this.historyLog = historyLog;
        eventBus.subscribe(CloseDialogRequestedEvent.class, this::onCloseDialogRequested);
    }

    private void onCloseDialogRequested(CloseDialogRequestedEvent event) {
        historyLog.append(textArea.getText());
    }

}
