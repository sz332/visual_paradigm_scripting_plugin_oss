package hu.resanbt.visualparadigm.scripting.common.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LocalStorage {

    public File getOrCreate(String fileName) {

        File file = new File(System.getProperty("user.home") +
                System.getProperty("file.separator") +
                ".vp-scripting-plugin" +
                System.getProperty("file.separator"),
                fileName);

        try {
            if (!file.exists()) {
                Files.createDirectories(file.getParentFile().toPath());
                Files.createFile(file.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
