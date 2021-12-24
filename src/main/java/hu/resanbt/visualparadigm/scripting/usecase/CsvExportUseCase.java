package hu.resanbt.visualparadigm.scripting.usecase;

import com.opencsv.CSVWriterBuilder;
import hu.resanbt.visualparadigm.scripting.common.csv.CsvData;
import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.ExceptionOccurredEvent;
import hu.resanbt.visualparadigm.scripting.event.ExportFileSelectedEvent;
import hu.resanbt.visualparadigm.scripting.event.TabularResultCreatedEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class CsvExportUseCase implements UseCase {

    private final EventBus eventBus;

    private Optional<TabularResult> result = Optional.empty();

    public CsvExportUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.subscribe(TabularResultCreatedEvent.class, this::onSmartGridResultCreated);
        eventBus.subscribe(ExportFileSelectedEvent.class, this::onExportFileSelect);
    }

    public void onSmartGridResultCreated(TabularResultCreatedEvent event) {
        this.result = Optional.of(event.getTabularResult());
    }

    public void onExportFileSelect(ExportFileSelectedEvent event) {
        result.ifPresent(result -> {
            try (var writer = new CSVWriterBuilder(new FileWriter(event.getFile())).withSeparator(';').build()) {
                var data = new CsvData(result).asRawData();
                writer.writeAll(data);
            } catch (IOException e) {
                eventBus.publish(new ExceptionOccurredEvent(e));
            }
        });
    }

}
