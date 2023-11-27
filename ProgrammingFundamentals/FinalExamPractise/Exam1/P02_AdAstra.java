package ProgrammingFundamentals.FinalExamPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#\\\\|])(?<itemName>[A-Z][a-z]+\\s?[A-Z]?[a-z]*)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1");
        Matcher matcher = pattern.matcher(text);

        int totalCalories = 0;
        List<String> informationList = new ArrayList<>();
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");

            String calories = matcher.group("calories");
            totalCalories += Integer.parseInt(calories);

            String info = String.format("Item: %s, Best before: %s, Nutrition: %s", itemName, expirationDate ,calories);
            informationList.add(info);
        }

        int daysCount = 0;
        while (totalCalories >= 2000) {
            daysCount++;
            totalCalories -= 2000;
        }

        System.out.printf("You have food to last you for: %d days!\n", daysCount);
        informationList.forEach(System.out::println);
    }
}
