package io.github.janczura.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static String path = Paths.get("").toAbsolutePath().toString() + File.separator + "polishWords" + File.separator;

    public File openFile(String path) {
        return new File("test.txt");
    }

    public void init() throws IOException {
        createInitConfigFileAndDir();
    }

    public void createFile(String path) throws IOException {
        new File("test.txt").createNewFile();
    }

    public String getFileContent(String fileName) throws IOException {
        String fullPath = path+fileName;
        return new String(Files.readAllBytes(Paths.get(fullPath)));
    }

    private void createInitConfigFileAndDir() throws IOException {
        String configPath = path + "config.txt";
        System.out.println("Creating " + configPath);
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
            new File(configPath).createNewFile();
        }
    }
}
