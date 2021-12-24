package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.HistoryRecordSelectedEvent;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DisplaySelectedHistoryRecordInEditorUseCase implements UseCase {

    private final JComboBox comboBox;
    private final RSyntaxTextArea textArea;

    public DisplaySelectedHistoryRecordInEditorUseCase(EventBus eventBus, JComboBox comboBox, RSyntaxTextArea textArea) {
        this.comboBox = comboBox;
        this.textArea = textArea;
        eventBus.subscribe(HistoryRecordSelectedEvent.class, this::onHistoryRecordSelected);
    }

    private void onHistoryRecordSelected(HistoryRecordSelectedEvent event) {

        SwingUtilities.invokeLater(() -> {
            comboBox.setSelectedItem(event.getHistoryRecord().getLanguage());

            var decodedString = new String(Base64.getDecoder().decode(event.getHistoryRecord().getScript()), StandardCharsets.UTF_8);
            textArea.setText(decodedString);
        });
    }

}
