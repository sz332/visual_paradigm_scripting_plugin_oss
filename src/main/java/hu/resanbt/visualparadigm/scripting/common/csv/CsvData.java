package hu.resanbt.visualparadigm.scripting.common.csv;

import hu.resanbt.visualparadigm.scripting.common.reflection.Bean;
import hu.resanbt.visualparadigm.scripting.common.result.SmartGridResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("squid:S3878")
public class CsvData {

    private final SmartGridResult grid;

    public CsvData(SmartGridResult grid) {
        this.grid = grid;
    }

    public List<String[]> asRawData() {
        var headerStream = Arrays.asList(
                new String[][]{grid.getFields().values().toArray(String[]::new)}
        ).stream();

        var dataStream =
                grid.getList().stream()
                        .map(obj ->
                                grid.getFields()
                                        .keySet()
                                        .stream()
                                        .map(k -> Bean.of(obj).propertyAsString(k))
                                        .toArray(String[]::new));

        return Stream.concat(headerStream, dataStream).collect(Collectors.toList());
    }

}
