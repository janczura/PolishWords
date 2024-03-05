package io.github.janczura;

import io.github.janczura.days.DayData;
import io.github.janczura.days.WordData;

import java.util.*;

public class Chatter {
    private final Set<Integer> randomedValues = new HashSet<>();

    public Chatter(DayData dayData) {
        System.out.println("Przetłumacz wyrazy: ");
        int size = dayData.getWords().size();
        List<WordData> wordDataSet = dayData.getWords();
        for (int i = 0; i < size; i++) {
            WordData random = getRandomWord(wordDataSet);
            System.out.println(random.getPl() + " to :");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            scanner.close();
            random.setExplained(input);
        }

        for (WordData wordData : dayData.getWords()) {
            System.out.println(wordData.getPl() + " to " + wordData.getEn() + " (" + wordData.getCn() + ")");
            System.out.println("Twoja odpowiedź: " + wordData.getExplained());
        }

    }

    private WordData getRandomWord(List<WordData> wordData) {
        int size = wordData.size();
        Random random = new Random();
        int randInt = random.nextInt(size);
        while (!randomedValues.contains(randInt)) {
            randInt = random.nextInt(size);
        }
        randomedValues.add(randInt);
        return wordData.get(randInt);
    }

}
