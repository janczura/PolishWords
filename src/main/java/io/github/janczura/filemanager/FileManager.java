package io.github.janczura.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public void createFile(String fileName, String data) throws IOException {
        new File(path + fileName).createNewFile();
        insertDataToFile(path + fileName, data);
    }

    public String getFileContent(String fileName) {
        String content = null;
        try {
            String fullPath = path + fileName;
            content = new String(Files.readAllBytes(Paths.get(fullPath)));
        } catch (Exception ignored) {
        }
        return content;
    }

    public void insertDataToFile(String path, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
            System.out.println("Zawartość została zapisana do pliku.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    private void createInitConfigFileAndDir() throws IOException {
        String configPath = path + "config.txt";
        System.out.println("Creating " + configPath);
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
            new File(configPath).createNewFile();
            insertDataToFile(path, "https://raw.githubusercontent.com/janczura/PolishWords/master/src/main/resources/days.json");
        }
    }
}
