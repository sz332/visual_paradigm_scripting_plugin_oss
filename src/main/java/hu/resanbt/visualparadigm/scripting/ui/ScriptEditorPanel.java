package hu.resanbt.visualparadigm.scripting.ui;

import hu.resanbt.visualparadigm.scripting.common.annotation.OnEventDispatcherThread;
import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryComboBoxRenderer;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryLog;
import hu.resanbt.visualparadigm.scripting.common.history.HistoryRecord;
import hu.resanbt.visualparadigm.scripting.common.storage.LocalStorage;
import hu.resanbt.visualparadigm.scripting.common.ui.KeyPressedForwarder;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.*;
import hu.resanbt.visualparadigm.scripting.script.GroovyScriptExecutor;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutor;
import hu.resanbt.visualparadigm.scripting.usecase.*;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({"squid:S1068", "squid:S1948"})
public class ScriptEditorPanel extends BaseScriptEditorPanel {

    private final EventBus eventBus;
    private final ScriptExecutor executor;
    private final HistoryLog historyLog;

    private final UseCase[] useCases;

    public ScriptEditorPanel(EventBus eventBus) {
        super();
        this.eventBus = eventBus;
        this.executor = new GroovyScriptExecutor();
        this.historyLog = new HistoryLog(eventBus, new LocalStorage());

        this.updateComponents();

        useCases = new UseCase[]{
                new AppendScriptToHistoryOnCloseUseCase(eventBus, this.historyLog, this.scriptTextArea),
                new AppendScriptToHistoryUseCase(eventBus, this.historyLog, this.scriptTextArea),
                new CsvExportUseCase(eventBus),
                new DisplayEmptyResultOnOutputUseCase(eventBus, this.outputTextArea),
                new DisplayExceptionOnOutputUseCase(eventBus, this.outputTextArea),
                new DisplayListResultInTableUseCase(eventBus, this.outputTable),
                new DisplayScriptExecutionFailedOnOutputUseCase(eventBus, this.outputTextArea),
                new DisplaySelectedHistoryRecordInEditorUseCase(eventBus, this.scriptTextArea),
                new DisplaySmartGridResultInTableUseCase(eventBus, this.outputTable),
                new DisplayStringResultOnOutputTextUseCase(eventBus, this.outputTextArea),
                new ExecuteSelectedScriptUseCase(eventBus, executor),
                new FilterTableUseCase(eventBus, this.outputTable),
                new FocusOnResultGridWhenRequestedUseCase(eventBus, this.resultTabbedPane),
                new FocusOnResultTextAreaWhenRequestedUseCase(eventBus, this.resultTabbedPane),
                new LoadHistoryOnDialogDisplayUseCase(eventBus, this.historyLog, this.historyComboBox),
                new RefreshHistoryOnHistoryChangeUseCase(eventBus, this.historyLog, this.historyComboBox),
                new SelectErroneousLineUseCase(eventBus, this.scriptTextArea)};

        eventBus.publish(new DialogDisplayedEvent());
    }

    @OnEventDispatcherThread
    private void updateComponents() {

        this.scriptTextArea.setCodeFoldingEnabled(true);
        this.scriptTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GROOVY);
        this.scriptTextArea.setAntiAliasingEnabled(true);

        this.scriptTextScrollPane.setLineNumbersEnabled(true);

        this.historyComboBox.setRenderer(new HistoryComboBoxRenderer());

        this.tableFilterTextField.addKeyListener(new KeyPressedForwarder(this::filterTableCommand));
        this.historyComboBox.addItemListener(this::selectHistoryCommand);
        this.appendToHistoryButton.addActionListener(this::appendToHistoryCommand);
        this.closeButton.addActionListener(this::closeDialogCommand);
        this.executeButton.addActionListener(this::executeScriptCommand);
        this.exportButton.addActionListener(this::exportCsvCommand);
    }

    private void filterTableCommand(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            eventBus.publish(new FilterRequestedEvent(tableFilterTextField.getText()));
        }
    }

    @OnEventDispatcherThread
    private void selectHistoryCommand(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            eventBus.publish(new HistoryRecordSelectedEvent((HistoryRecord) e.getItem()));
        }
    }

    @OnEventDispatcherThread
    private void appendToHistoryCommand(ActionEvent e) {
        eventBus.publish(new AppendScriptToHistoryRequestedEvent());
    }

    @OnEventDispatcherThread
    private void closeDialogCommand(ActionEvent e) {
        eventBus.publish(new CloseDialogRequestedEvent());
    }

    @OnEventDispatcherThread
    private void executeScriptCommand(ActionEvent e) {
        eventBus.publish(new ScriptExecutionRequestedEvent(scriptTextArea.getText()));
    }

    @OnEventDispatcherThread
    private void exportCsvCommand(ActionEvent e) {
        var fileChooser = new JFileChooser();

        if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(null)) {
            eventBus.publish(new ExportFileSelectedEvent(fileChooser.getSelectedFile()));
        }
    }

}
