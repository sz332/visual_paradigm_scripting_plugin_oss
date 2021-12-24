package hu.resanbt.visualparadigm.scripting.common.csv;

import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("squid:S3878")
public class CsvData {

    private final TabularResult result;

    public CsvData(TabularResult result) {
        this.result = result;
    }

    public List<String[]> asRawData() {
        var headerStream = Arrays.asList(
                new String[][]{result.getFields().values().toArray(String[]::new)}
        ).stream();

        var dataStream =
                result.getList().stream()
                        .map(obj ->
                                result.getFields()
                                        .keySet()
                                        .stream()
                                        .map(k -> result.getPropertyReader().getPropertyNameAsString(obj, k))
                                        .toArray(String[]::new));

        return Stream.concat(headerStream, dataStream).collect(Collectors.toList());
    }

}
