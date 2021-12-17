package hu.resanbt.visualparadigm.scripting.common.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

    private static final String FILENAME = System.getProperty("user.home") +
            System.getProperty("file.separator") + "vp-scripting-plugin.log";

    private Logger() {
        // do nothing
    }

    public static void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter out = new BufferedWriter(new FileWriter(FILENAME, true))) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            out.write("[" + formatter.format(timestamp) + " ] " + message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
