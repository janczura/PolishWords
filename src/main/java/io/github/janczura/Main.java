package io.github.janczura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Get day? (example 2024-03-05 or leave empty for today): ");
        String input = scanner.nextLine();
        System.out.println("Entered: " + input);
        scanner.close();

        if(input==null || input.isEmpty()){
            LocalDateTime dateTime = LocalDateTime.now();
            LocalDate date = dateTime.toLocalDate();
            input = date.toString();
        }

        PolishWords polishWords = new PolishWords();
        polishWords.run(input);
    }
}