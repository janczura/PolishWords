package io.github.janczura;

import io.github.janczura.days.DayData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DayManager {
    public DayData getTodayDay(Date dateObj, List<DayData> dayDataList) {
        for (DayData dayData : dayDataList) {
            if (getStringFormatOfDate(dateObj).equals(dayData.getDay())) {
                return dayData;
            }
        }
        return null;
    }

    private String getStringFormatOfDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        return format.format(date);
    }
}
