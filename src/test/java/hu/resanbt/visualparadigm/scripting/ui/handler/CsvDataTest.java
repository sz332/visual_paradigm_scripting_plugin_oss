package hu.resanbt.visualparadigm.scripting.ui.handler;

import hu.resanbt.visualparadigm.scripting.common.csv.CsvData;
import hu.resanbt.visualparadigm.scripting.common.result.SmartGridResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvDataTest {

    private static List<Object> createTestData() {
        return Arrays.asList(new MyClass("1", "a"), new MyClass("2", "b"));
    }

    @Test
    public void testConversionToRawData() {
        var properties = new HashMap<String, String>();
        properties.put("name", "Name");
        properties.put("id", "Id");

        SmartGridResult grid = new SmartGridResult(createTestData(), properties);
        CsvData csvData = new CsvData(grid);

        var rawData = csvData.asRawData();

        Assert.assertNotNull(rawData);
    }

}
