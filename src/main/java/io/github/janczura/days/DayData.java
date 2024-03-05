package io.github.janczura.days;

import java.util.List;

public class DayData {
    private String day;
    private List<WordData> words;

    public DayData(String day, List<WordData> words) {
        this.day = day;
        this.words = words;
    }

    public String getDay() {
        return day;
    }

    public List<WordData> getWords() {
        return words;
    }

    @Override
    public String toString() {
        return "DayData{" +
                "day='" + day + '\'' +
                ", words=" + words +
                '}';
    }
}
