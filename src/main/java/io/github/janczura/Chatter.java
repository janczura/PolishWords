package io.github.janczura;

import io.github.janczura.days.DayData;
import io.github.janczura.days.WordData;

import java.util.*;

public class Chatter {
    private final Set<Integer> randomedValues = new HashSet<>();

    public Chatter(DayData dayData) {
        System.out.println("Translate or explain words: ");
        int size = dayData.getWords().size();
        List<WordData> wordDataSet = dayData.getWords();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            WordData random = getRandomWord(wordDataSet);
            System.out.println(random.getPl() + " means ");
            String input = scanner.nextLine();
            random.setExplained(input);
        }
        scanner.close();

        for (WordData wordData : dayData.getWords()) {
            System.out.println(wordData.getPl() + " means " + wordData.getEn() + " (" + wordData.getCn() + ")");
            System.out.println("Your answer: " + wordData.getExplained());
        }

    }

    private WordData getRandomWord(List<WordData> wordData) {
        int size = wordData.size();
        Random random = new Random();
        int randInt = random.nextInt(size);
        while (randomedValues.contains(randInt)) {
            randInt = random.nextInt(size);
        }
        randomedValues.add(randInt);
        return wordData.get(randInt);
    }

}
