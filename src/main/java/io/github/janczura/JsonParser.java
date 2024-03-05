package io.github.janczura;

import io.github.janczura.days.DayData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.janczura.days.WordData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<DayData> parseJson(String json) throws IOException {
        List<DayData> dayDataList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        JsonNode daysNode = rootNode.path("days");
        for (JsonNode dayNode : daysNode) {
            String day = dayNode.path("day").asText();
            JsonNode wordsNode = dayNode.path("words");

            List<WordData> wordDataList = new ArrayList<>();
            for (JsonNode wordNode : wordsNode) {
                String pl = wordNode.path("pl").asText();
                String en = wordNode.path("en").asText();
                String cn = wordNode.path("cn").asText();
                wordDataList.add(new WordData(pl, en, cn));
            }

            dayDataList.add(new DayData(day, wordDataList));
        }

        return dayDataList;
    }
}
