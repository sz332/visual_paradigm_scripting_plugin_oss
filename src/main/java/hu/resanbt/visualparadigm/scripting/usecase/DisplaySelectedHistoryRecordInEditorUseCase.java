package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.HistoryRecordSelectedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DisplaySelectedHistoryRecordInEditorUseCase implements UseCase {

    private final RSyntaxTextArea textArea;

    public DisplaySelectedHistoryRecordInEditorUseCase(EventBus eventBus, RSyntaxTextArea textArea) {
        this.textArea = textArea;
        eventBus.subscribe(HistoryRecordSelectedEvent.class, this::onHistoryRecordSelected);
    }

    private void onHistoryRecordSelected(HistoryRecordSelectedEvent event) {
        String decodedString = new String(Base64.getDecoder().decode(event.getHistoryRecord().getScript()), StandardCharsets.UTF_8);
        this.textArea.setText(decodedString);
    }

}
