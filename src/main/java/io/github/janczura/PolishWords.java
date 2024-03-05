package io.github.janczura;

import io.github.janczura.filemanager.FileManager;

import java.io.IOException;
import java.util.Date;

public class PolishWords {
    public final FileManager fileManager;

    public PolishWords() {
        this.fileManager = new FileManager();
    }

    public void run(String date) throws IOException {
        Date dateObj = new Date(date);
        Date dateNow = new Date();
        if (dateNow.before(dateObj)) {
            dateObj = dateNow;
        }
        try {
            fileManager.init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = fileManager.getFileContent("config.txt");
        if (url!=null && !url.isEmpty()){
            JsonDownloader jsonDownloader = new JsonDownloader();
            String response = jsonDownloader.getResponse();

        }else {
            System.out.println("config.txt is empty");
        }
        DayManager dayManager = new DayManager();
    }
}
