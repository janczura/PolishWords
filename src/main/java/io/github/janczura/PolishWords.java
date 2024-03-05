package io.github.janczura;

import io.github.janczura.days.DayData;
import io.github.janczura.filemanager.FileManager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PolishWords {
    //public final FileManager fileManager;

    public PolishWords() {
        //this.fileManager = new FileManager();
    }

    public void run(String date) throws IOException {
        Date dateObj = getDateFromString(date);
        Date dateNow = new Date();
        if (dateObj == null || dateNow.before(dateObj)) {
            dateObj = dateNow;
        }
        //fileManager.init();

        String url = "https://raw.githubusercontent.com/janczura/PolishWords/master/src/main/resources/days.json"; //fileManager.getFileContent("config.txt");
        if (url != null && !url.isEmpty()) {
            JsonDownloader jsonDownloader = new JsonDownloader();
            String response = jsonDownloader.getResponse(url);
            if (response != null) {
                JsonParser jsonParser = new JsonParser();
                List<DayData> dayDataList = jsonParser.parseJson(response);
                DayManager dayManager = new DayManager();
                DayData dayData = dayManager.getTodayDay(dateObj, dayDataList);
                if (dayData != null) {
                    new Chatter(dayData);
                } else {
                    System.out.println("Data for " + dateObj + " does not exist");
                }
            } else {
                System.out.println("Error getting words");
            }
        } else {
            System.out.println("config.txt is empty");
        }
    }

    private Date getDateFromString(String date) {
        String dateString = date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Date datee = format.parse(dateString);
            return datee;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
